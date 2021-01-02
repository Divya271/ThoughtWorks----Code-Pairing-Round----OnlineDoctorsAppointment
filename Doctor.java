import java.time.*;
import java.util.*;
public class Doctor{
	private String SPECIALITY;
	private LocalDateTime start, end;
	private ArrayList<Patient> patients;

	Doctor(String SPECIALITY, LocalDateTime start, LocalDateTime end){
		this.SPECIALITY = SPECIALITY;

		this.patients = new ArrayList<Patient>();
		setStartTime(start);
		setEndTime(end);
	}

	public String getSpeciality(){
		return this.SPECIALITY;
	}
	public LocalDateTime getStartTime(){
		return this.start;
	}

	public LocalDateTime getEndTime(){
		return this.end;
	} 
	public List<Patient> getPatients(){
		return this.patients;
	}

	public void setSpeciality(String sp){
		this.SPECIALITY = sp;
	}
	
	public void setStartTime(LocalDateTime start){
		this.start = start;
	}

	public void setEndTime(LocalDateTime end){
		this.end = end;
	}
	public void addPatient(Patient patient){
		patients.add(patient);
	}

	public boolean isAvailable(Patient p1){
		LocalDateTime start = p1.getStartTime(); 
		LocalDateTime end = p1.getEndTime();
		if(!start.isAfter(this.getStartTime()) || !end.isBefore(this.getEndTime()))
			return false;
		for(Patient p2 : patients){
			if(!intersected(p1.getEndTime(), p2.getStartTime()) && !intersected(p2.getEndTime(), p1.getStartTime()))
				return false;
		}
		return true;
	}

	private boolean intersected(LocalDateTime t1, LocalDateTime t2){
		return t1.isBefore(t2);
	}
	
}