package com.example.design.factory;

class ProfessionFactory {
    public Profession getProfession(String professionName) {
        if (professionName.equalsIgnoreCase("Doctor")) {
            return new Doctor();
        }
        if (professionName.equalsIgnoreCase("Engineer")) {
            return new Engineer();
        }
        if (professionName.equalsIgnoreCase("Teacher")) {
            return new Teacher();
        }
        return null;
    }
}
