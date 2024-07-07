package com.model;



import java.util.ArrayList;



import org.hibernate.Session;

import org.hibernate.Transaction;



import com.sun.tools.javac.util.List;



public class Test {

public static void main(String[] args) {

	Transaction tr=null;

	try(Session ses=HBUtil.getSf().openSession()){

			tr=ses.beginTransaction();

			Answer a1=new Answer();

			a1.setAnswername("One answer");

			a1.setPostedBy("Ramesh");

			Answer a2=new Answer();

			a2.setAnswername("Second Answer");

			a2.setPostedBy("Sumesh");

		    ArrayList<Answer> li=new ArrayList<Answer>();

			li.add(a1);

			li.add(a2);

			Question q1=new Question();

			q1.setQname("First Question");

			q1.setAnswers(li);

			ses.merge(q1);

			tr.commit();

			ses.close();

}

	catch(Exception e) {

		e.printStackTrace();

	}

}

}