package com.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import com.model.CandidateReg;
import com.model.VoterReg;

public class EVM {
	Scanner s=new Scanner(System.in);
	HashSet<VoterReg> voterData=new HashSet<>();
	Set<CandidateReg> candidateData=new HashSet<>();
	public void voterReg()
	{
		System.out.println("Enter your Name:");
		String name=s.next()+s.nextLine();
		System.out.println("Enter your Birth date in YYYY-MM-DD format:");
		try {
				DateDob(name);
		}catch (Exception e) {
			try {
					System.err.println("Invalid Date formate ");
					System.out.println("please write in that YYYY-MM-DD format: ");
					DateDob(name);
			} catch (Exception e2) {
				try {
				
					System.err.println("Invalid Date formate ");
					System.out.println("please write in that YYYY-MM-DD format: ");
					DateDob(name);
				} catch (Exception e3) {
					System.err.println("sorry date format is wrong");
					//e3.printStackTrace();
				}
			}
			
		}
	}	
		
	public static int calculateAge(LocalDate dob)
	{
		LocalDate curDate=LocalDate.now();
		if(dob !=null && curDate !=null)
		{
			return Period.between(dob, curDate).getYears();
		}else {
			return 0;
		}
	}
	public void displyVoter()
	{
		boolean empty=false;
		System.out.println("______________________________voter List___________________________________");
		for(VoterReg i:voterData)
			{
				System.out.println(i);
				empty=true;
			}
		if(empty==false)
		{
			System.err.println("voter list is empty..");
		}

	}
	
	public void vote()
	{
		System.out.println("Enter your voter Id:");
		int vId=s.nextInt();
		boolean check=false;
		VoterReg temp=null;
		for(VoterReg i:voterData)
		{
			if(i.getId()==vId)
			{
				check=true;
				temp=i;
				break;
			}
		}
		if(check==true)
		{
			if(temp.getVoting()==false)
			{
				System.out.println("These candidate are standing for voting");
				for(CandidateReg i:candidateData)
				{
					System.out.println(i);
				}
					System.out.println("enter id to you want vote:");
					int id=s.nextInt();
					boolean ch=false;
					for(CandidateReg i:candidateData)
					{
						if(i.getId()==id)
						{
							ch=true;
						}
					}
					if(ch!=true)
					{
						System.err.println("Invalid candidate id ");
						System.out.println("Enter candidate id again:");
						id=s.nextInt();
					}
					
					
					for(CandidateReg i:candidateData)
					{
						if(i.getId()==id)
						{
								i.setVote(1);
								temp.isVoting(true);
								System.out.println("Your vote is succesfully");
								ch=true;
								break;
							
						}
					}
					
					
					
				
			}else {
				System.err.println("Voter is allready voteing");
			}
			
		}else {
			System.err.println("Voter Id is in valid");
		}
	}
	
	public void Candidatereg()
	{
		
		CandidateReg c=new CandidateReg(101,"Iron Man", "Satara","NCP", "phaltan", 33);
		CandidateReg c1=new CandidateReg(102,"Spider Man", "Pune","BJP", "phaltan", 23);
		CandidateReg c2=new CandidateReg(103,"Bat Man", "Mumbai","AAP", "phaltan", 43);
		
		candidateData.add(c);
		candidateData.add(c1);
		candidateData.add(c2);
		
	}
	public void result()
	{
		int max=Integer.MIN_VALUE;
		
		for(CandidateReg i:candidateData)
		{
			if(max<i.getVote())
			{
				max=i.getVote();
				
			}
		}
		for(CandidateReg i:candidateData)
		{
			System.out.println("ID:"+i.getId()+"    Name:"+i.getName()+"   Vote:"+i.getVote());
		}
		System.out.println("____________________________Winner___________________________");
		int j=0;
		for(CandidateReg i:candidateData)
		{	
			
			if(max==i.getVote())
			{
				j++;
				System.out.println("ID:"+i.getId()+"  Name:"+i.getName()+"   Vote:"+i.getVote());
				if(j>1)
				{
					System.out.println(j+" candidate vote are same ");
				}
				
			}
		}

		
	}
	public void DateDob(String name) throws AadharException
	{
		String date=s.next()+s.nextLine();
		LocalDate dob=LocalDate.parse(date);
		if(calculateAge(dob)>=18)
		{
			System.out.println("Enter your address:");
			String address=s.next()+s.nextLine();
			try {
			System.out.println("Enter your aadhar no:");
			
			long aadharNo=s.nextLong();
			String aadhar=Long.toString(aadharNo);
			if(aadhar.length()==12)
			{
				int id=(int)(Math.random()*100+1);
				System.out.println("Your voter ID:"+id);
				VoterReg v=new VoterReg(id,name, address, aadharNo,  date,calculateAge(dob));
				voterData.add(v);
			}else
			{
				throw new AadharException("Invalid aadhar number:");
			}
			}catch (AadharException e) {
				System.err.println("Invalid input please enter valid aadhar no:");
			}
			
		}else {
			System.err.println("Your not eligible for voting");
		}
		
		
	
	}

}
