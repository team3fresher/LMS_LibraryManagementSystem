package com.team3.LMS.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.PaymentDao;
import com.team3.LMS.dto.Payment;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;

	public List<Payment> getPaymentList() {
		return (List<Payment>) paymentDao.findAll();
	}

	public Page<Payment> findAll(Pageable pageable) {
		return paymentDao.findAll(pageable);
	}

	public void addPayment(Payment payment) {
		paymentDao.save(payment);
	}

	public void removePayment(int paymentId) {
		paymentDao.delete(paymentId);
	}

	public Payment getPayment(int paymentId) {
		return paymentDao.findOne(paymentId);
	}
	
	public String getPaymentDataReport(){
		List<Payment> lstPayment = (List<Payment>) getPaymentList();
		int[] year = new int[6];
		int[] month = new int[13];
		String[] monthLabel = {"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; 
		
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		year[5] = calendar.get(Calendar.YEAR); //year[5] is current year
		
		for (Payment payment : lstPayment) {
			Date date = payment.getPayDay();
			Calendar payDate = Calendar.getInstance();
			payDate.setTime(date);
			int pMonth = payDate.get(Calendar.MONTH)+1;
			int pYear = payDate.get(Calendar.YEAR);
			
			int amount = (payment.getPaymentAmount() + payment.getFine());
			if(pYear == year[5]){							
				switch (pMonth) {			
				case 1:
					month[1] += amount;
					break;
				case 2:
					month[2] += amount;
					break;
				case 3:
					month[3] += amount;
					break;
				case 4:
					month[4] += amount;
					break;
				case 5:
					month[5] += amount;
					break;
				case 6:
					month[6] += amount;
					break;
				case 7:
					month[7] += amount;
					break;
				case 8:
					month[8] += amount;
					break;
				case 9:
					month[9] += amount;
					break;
				case 10:
					month[10] += amount;
					break;
				case 11:
					month[11] +=amount;
					break;
				case 12:
					month[12] += amount;
					break;
				default:
					break;
				}
			}
			
			//get by year			
			if(pYear==year[5]){
				year[0] += amount;
			}else if(pYear==(year[5]-1)){
				year[1] += amount;
			}else if(pYear==(year[5]-2)){
				year[2] += amount;
			}else if(pYear==(year[5]-3)){
				year[3] += amount;
			}else if(pYear==(year[5]-4)){
				year[4] += amount;
			}			
		}
		
		//json to show for monthly
		String monthlyData = "";		
		for(int i = 1; i<=12;i++){
			monthlyData += "{"
					+ "			\"label\": \""+monthLabel[i]+"\","
					+ "			\"value\": \""+month[i]+"\""
					+ "		},";
		}
		
		monthlyData = monthlyData.replaceAll(",$", "");		//delete the comma at the end of string
		
		String monthly = "\"reportByMonth\":{"
				+ "		\"chart\": {"
				+ "			\"xAxisName\": \"Month in Year "+year[5]+"\","
				+ "			\"yAxisName\": \"Income (VND)\""
				+ "				},"
				+ "		\"data\":["
				+ monthlyData
				+ "	]"
				+ "},";
		
		//json to show for yearly
		String yearlyData = "";		
		for(int i = year.length-2; i>=0;i--){
			yearlyData += "{"
					+ "			\"label\": \""+(year[5]-i)+"\","
					+ "			\"value\": \""+year[i]+"\""
					+ "		},";
		}
		
		yearlyData = yearlyData.replaceAll(",$", "");		//delete the comma at the end of string
		
		String yearly = "\"reportByYear\":{"
				+ "		\"chart\": {"
				+ "			\"xAxisName\": \"Year\","
				+ "			\"yAxisName\": \"Income (VND)\""
				+ "				},"
				+ "		\"data\":["
				+ yearlyData
				+ "]"
				+ "}";
		
		String data = "{"+monthly + yearly+"}";
		return data;
	}
}
