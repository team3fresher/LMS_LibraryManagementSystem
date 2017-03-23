package com.team3.LMS.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.TicketDao;
import com.team3.LMS.dto.Ticket;

@Service
public class TicketService {
	@Autowired
	private TicketDao ticketDao;

	public List<Ticket> getTicketList() {
		return (List<Ticket>) ticketDao.findAll();
	}

	public Page<Ticket> findAll(Pageable pageable) {
		return ticketDao.findAll(pageable);
	}

	public void addTicket(Ticket ticket) {
		ticketDao.save(ticket);
	}

	public void removeTicket(int id) {
		ticketDao.delete(id);
	}

	public Ticket getTicket(int id) {
		return ticketDao.findOne(id);
	}
		
	public String getTicketDataReport(){
		List<Ticket> lst = getTicketList();
		int[] month = new int[12];	
		int[] year = new int[5];		
		int[] week = new int[7];
		
				
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);		
		int curYear = calendar.get(Calendar.YEAR);
		int curMonth = calendar.get(Calendar.MONTH)+1;				
		int maxWeekofCurMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		for (Ticket ticket : lst) {
			Date date = ticket.getBorrowedDate();
			Calendar borrowedDate = Calendar.getInstance();
			borrowedDate.setTime(date);
			int tWeek = borrowedDate.get(Calendar.DAY_OF_WEEK_IN_MONTH);
			int tMonth = borrowedDate.get(Calendar.MONTH)+1;
			int tYear = borrowedDate.get(Calendar.YEAR);
			
			//get by month
			if(tYear==curYear){
				switch (tMonth) {			
				case 1:
					month[1]++;
					break;
				case 2:
					month[2]++;
					break;
				case 3:
					month[3]++;
					break;
				case 4:
					month[4]++;
					break;
				case 5:
					month[5]++;
					break;
				case 6:
					month[6]++;
					break;
				case 7:
					month[7]++;
					break;
				case 8:
					month[8]++;
					break;
				case 9:
					month[9]++;
					break;
				case 10:
					month[10]++;
					break;
				case 11:
					month[11]++;
					break;
				case 12:
					month[0]++;
					break;
				default:
					break;
				}
				
				if(tMonth == curMonth){
					//get by weekly
					switch(tWeek){
					case 1:
						week[1]++;
						break;
					case 2:
						week[2]++;
						break;
					case 3:
						week[3]++;
						break;
					case 4:
						week[4]++;
						break;
					case 5:
						week[5]++;
						break;
					case 6:
						week[6]++;
						break;
					default:
						break;
					}
				}
			}					
			//get by year
			if(tYear==curYear){
				year[0]++;
			}else if(tYear==(curYear-1)){
				year[1]++;
			}else if(tYear==(curYear-2)){
				year[2]++;
			}else if(tYear==(curYear-3)){
				year[3]++;
			}else if(tYear==(curYear-4)){
				year[4]++;
			}										
			
		}
		
		String weeklyData = "";
		for(int i = 1; i<=maxWeekofCurMonth;i++){
			weeklyData += "{"
					+ "			\"label\": \"week "+i+"\","
					+ "			\"value\": \""+week[i]+"\""
					+ "		},";
		}
		weeklyData = weeklyData.replaceAll(",$", "");		//delete the comma at the end of string
		String weekly = "\"reportByWeek\":{"
				+ "		\"chart\": {"
				+ "			\"xAxisName\": \"Week in Month "+curMonth+"\","
				+ "			\"yAxisName\": \"Ticket Quantity\""
				+ "				},"
				+ "		\"data\":["
				+ weeklyData
				+ "]"
				+ "},";
		
		String dataReport = "{"
				+ "\"reportByYear\":{"
				+ "		\"chart\": {"
				+ "			\"xAxisName\": \"Year\","
				+ "			\"yAxisName\": \"Ticket Quantity\""
				+ "				},"
				+ "		\"data\":["
				+ "		{"
				+ "			\"label\": \""+(curYear-4)+"\","
				+ "			\"value\": \""+year[4]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \""+(curYear-3)+"\","
				+ "			\"value\": \""+year[3]+"\""
				+ "		},"				
				+ "		{"
				+ "			\"label\": \""+(curYear-2)+"\","
				+ "			\"value\": \""+year[2]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \""+(curYear-1)+"\","
				+ "			\"value\": \""+year[1]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \""+curYear+"\","
				+ "			\"value\": \""+year[0]+"\""
				+ "		}"
				+ "	]"
				+ "},"
				+ ""+weekly+""
				+ "\"reportByMonth\":{"
				+ "		\"chart\": {"
				+ "			\"xAxisName\": \"Month in "+curYear+"\","
				+ "			\"yAxisName\": \"Ticket Quantity\""
				+ "				},"
				+ "		\"data\":["
				+ "		{"
				+ "			\"label\": \"Jan\","
				+ "			\"value\": \""+month[1]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Feb\","
				+ "			\"value\": \""+month[2]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Mar\","
				+ "			\"value\": \""+month[3]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Apr\","
				+ "			\"value\": \""+month[4]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"May\","
				+ "			\"value\": \""+month[5]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Jun\","
				+ "			\"value\": \""+month[6]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Jul\","
				+ "			\"value\": \""+month[7]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Aug\","
				+ "			\"value\": \""+month[8]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Sep\","
				+ "			\"value\": \""+month[9]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Oct\","
				+ "			\"value\": \""+month[10]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Nov\","
				+ "			\"value\": \""+month[11]+"\""
				+ "		},"
				+ "		{"
				+ "			\"label\": \"Dec\","
				+ "			\"value\": \""+month[0]+"\""
				+ "		}"				
				+ "	]"
				+ "}"
				+ "}";
		return  dataReport;
	}
}
