import java.time.*;
public class Patient{
	private String doctorSpeciality;
	private LocalDateTime start, end;
	Patient(String doctorSpeciality, LocalDateTime start, LocalDateTime end){
		setDoctorSpeciality(doctorSpeciality);
		setStartTime(start);
		setEndTime(end);
	}

	public String getDoctorSpeciality(){
		return this.doctorSpeciality;
	}

	public LocalDateTime getStartTime(){
		return this.start;
	}

	public LocalDateTime getEndTime(){
		return this.end;
	} 


	public void setDoctorSpeciality(String doctorSpeciality){
		this.doctorSpeciality = doctorSpeciality;
	}
	public void setStartTime(LocalDateTime start){
		this.start = start;
	}

	public void setEndTime(LocalDateTime end){
		this.end = end;
	}
}