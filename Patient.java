
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.UUID;

class Patient {
    UUID id;
    String name;
    int priority; // 1 (highest) to 5 (lowest)
    String condition;
    String vitalSigns; //Example vital signs

    public Patient(String name, int priority, String condition, String vitalSigns) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.priority = priority;
        this.condition = condition;
        this.vitalSigns = vitalSigns;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", condition='" + condition + '\'' +
                ", vitalSigns='" + vitalSigns + '\'' +
                '}';
    }
}

public class MedicalHeap {
    public static void main(String[] args) {
        // Create a PriorityQueue with a custom Comparator
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));

        // Add patients
        patientQueue.add(new Patient("Alice", 1, "Cardiac Arrest", "BP: 60/40, HR: 140"));
        patientQueue.add(new Patient("Bob", 3, "Severe Allergic Reaction", "Wheezing, Swelling"));
        patientQueue.add(new Patient("Charlie", 2, "Broken Leg", "Pain level 8/10"));
        patientQueue.add(new Patient("David", 5, "Headache", "Mild headache"));
        patientQueue.add(new Patient("Eve", 4, "Minor Cut", "Small superficial wound"));


        // Process patients
        System.out.println("Patients in order of priority:");
        while (!patientQueue.isEmpty()) {
            Patient patient = patientQueue.poll();
            System.out.println(patient);
            //Simulate treatment
            System.out.println("Patient "+ patient.name + " treated.");
            System.out.println("--------------------");
        }
    }
}