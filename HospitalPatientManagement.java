abstract class Patient {
    protected String patientId;
    protected String name;
    protected int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private String medicalHistory;

    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
        this.medicalHistory = "";
    }

    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record ;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + name + ": " + medicalHistory);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "";
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record ;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + name + ":\n" + medicalHistory);
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = {
                new InPatient("P1", "Amy", 32, 500, 3),
                new OutPatient("P2", "Gina", 30, 300)
        };

        for (Patient patient : patients) {
            patient.getPatientDetails();
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) patient;
                medicalRecord.addRecord("Seizures");
                medicalRecord.viewRecords();
            }
            System.out.println("Total Bill: " + patient.calculateBill() + "\n");
        }
    }
}