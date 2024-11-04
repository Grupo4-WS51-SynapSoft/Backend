package pe.edu.upc.center.platform.caregiver.domain.model.commands;


public record CreateCaregiverCommand(String completeName, Integer age, String address, Integer caregiverExperience, Integer completedServices,
         String biography, String profileImage, Long farePerHour, String districtsScope) {
}
