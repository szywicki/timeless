package com.libertymutual.goforcode.timeless.services;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.timeless.models.TimeTrackings;
@Service
public class TimeTrackingRepository {

	private ArrayList<TimeTrackings> items;
		
	
	public List<TimeTrackings> getAll() {

		try (FileReader reader = new FileReader("timetrackings.csv"); 
			CSVParser parser = CSVFormat.DEFAULT.parse(reader)) {
			List<CSVRecord> record = CSVFormat.DEFAULT.parse(reader).getRecords();
			items = new ArrayList<TimeTrackings>();
			
			for (CSVRecord current : record) {
				TimeTrackings item = new TimeTrackings();
				item.setDate(current.get(0));
				item.setMondayTime(Double.parseDouble(current.get(1)));
				item.setTuesdayTime(Double.parseDouble(current.get(2)));
				item.setWednesdayTime(Double.parseDouble(current.get(3)));
				item.setThursdayTime(Double.parseDouble(current.get(4)));
				item.setFridayTime(Double.parseDouble(current.get(5)));
				items.add(item);
			}
		if (items.isEmpty()) {
			return Collections.emptyList();
		}
		
		} catch (IOException e) {
			System.out.println("reading error");
		}
		
		return items;
	}

	public void create(TimeTrackings item) {
		
		try (FileWriter writer = new FileWriter("timetrackings.csv", true);
			CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {
			String[] record = {
					item.getDate(),
					Double.toString(item.getMondayTime()),
					Double.toString(item.getTuesdayTime()),
					Double.toString(item.getWednesdayTime()),
					Double.toString(item.getThursdayTime()), 
					Double.toString(item.getFridayTime()), 
					Double.toString(item.getTotal())
					
				};
			
			printer.printRecord(record);

		} catch (IOException e) {
			System.out.println("writing error");
		}
	}
}
