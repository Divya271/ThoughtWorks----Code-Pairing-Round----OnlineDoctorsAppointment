import java.util.*;
import java.time.*;
public class OnlineBooking{
	List<Doctor> doctors;
	OnlineBooking(){
		this.doctors = new ArrayList<>();
	}
	public void addDoctor(Doctor doctor){
		this.doctors.add(doctor);
	}
	public String bookAppointment(Patient patient){
		boolean isAvailableAtDifferentTime = false;
		String out = "Not available";
		for(Doctor doctor : doctors){
			if(doctor.getSpeciality().equals(patient.getDoctorSpeciality()) && doctor.isAvailable(patient)) {
				out = "Booking has been appointed for you with a " + doctor.getSpeciality();
				out += " on " + patient.getStartTime().getMonth() + ", " + patient.getStartTime().getYear();
				out += " at " + patient.getStartTime().getHour() + "AM";
				doctor.addPatient(patient);
				return out;
			}
		}
		return out;
	}
	public static void main(String[] args) {
		OnlineBooking onlineBooking = new OnlineBooking();
		onlineBooking.addDoctor(new Doctor("PEDITRICIA", LocalDateTime.of(2020, 6, 9, 2, 0), LocalDateTime.of(2020, 6, 9, 4, 0)));
		onlineBooking.addDoctor(new Doctor("PEDITRICIA", LocalDateTime.of(2020, 6, 9, 1, 0), LocalDateTime.of(2020, 6, 9, 4, 0)));
		onlineBooking.addDoctor(new Doctor("PEDITRICIA", LocalDateTime.of(2020, 6, 10, 1, 0), LocalDateTime.of(2020, 6, 10, 3, 0)));
		onlineBooking.addDoctor(new Doctor("ENT", LocalDateTime.of(2020, 6, 9, 2, 0), LocalDateTime.of(2020, 6, 9, 5, 30)));
		onlineBooking.addDoctor(new Doctor("ENT", LocalDateTime.of(2020, 6, 9, 2, 0), LocalDateTime.of(2020, 6, 9, 2, 30)));
 		
 		Patient p1 = new Patient("PEDITRICIA", LocalDateTime.of(2020, 6, 9, 2, 1), LocalDateTime.of(2020, 6, 9, 2, 30));
 		Patient p2 = new Patient("ENT", LocalDateTime.of(2020, 6, 9, 2, 1), LocalDateTime.of(2020, 6, 9, 2, 30));
 		Patient p3 = new Patient("PEDITRICIA", LocalDateTime.of(2020, 6, 9, 4, 0), LocalDateTime.of(2020, 6, 9, 4, 30));


 		System.out.println(onlineBooking.bookAppointment(p1));
 		System.out.println(onlineBooking.bookAppointment(p2));
 		System.out.println(onlineBooking.bookAppointment(p3));

	}
}