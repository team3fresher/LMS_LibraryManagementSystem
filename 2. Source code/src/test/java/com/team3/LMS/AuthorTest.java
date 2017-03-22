package com.team3.LMS;

import static org.junit.Assert.*;

import org.junit.Test;

import com.team3.LMS.dao.AuthorDetailDao;
import com.team3.LMS.dto.AuthorDetail;

import junit.framework.TestCase;

public class AuthorTest extends TestCase{

	private AuthorDetail author1;
	private AuthorDetail author2;
	private AuthorDetail author3;
	private AuthorDetail author4;
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(AuthorTest.class);
	}
	
	@Override
	public void setUp(){
		author1 = new AuthorDetail("Rumiko Takahashi");
		author2 = new AuthorDetail("Mark Twain");
		author3 = new AuthorDetail("Tran Luc");
		author4 = new AuthorDetail("CB");
	}
	
	@Test
	public void testAuthorEqual() {
		assertTrue(!author1.equals(null));
		AuthorDetail authorEqual = new AuthorDetail("CB");
		assertEquals(author4, author4);
		assertEquals(author4.getAuthorName(), authorEqual.getAuthorName());
		assertEquals(author4.getAuthorName().hashCode(), authorEqual.getAuthorName().hashCode());
		assertTrue(!author4.equals(author1));
	}
	
	@Test
	public void testAuthorHas(){
		assertTrue(!author2.equals(null));
		AuthorDetail test = new AuthorDetail("Mark Twain");
		assertEquals(author2.getAuthorName().hashCode(), test.getAuthorName().hashCode());
	}
	
	@Test
	public void testPrint(){
		assertEquals("Rumiko Takahashi", author1.getAuthorName());
	}
}
