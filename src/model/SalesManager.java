package model;

import java.time.LocalDate;

public class SalesManager extends User{
    public SalesManager() {
        super();
    }

    public SalesManager(int id, String username, String password, String fullName, LocalDate dateOfBirth, String idCard, String phone, String email, String address, String role) {
        super(id, username, password, fullName, dateOfBirth, idCard, phone, email, address, role);
    }

    public SalesManager(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setFullName(user.getFullName());
        this.setDateOfBirth(user.getDateOfBirth());
        this.setIdCard(user.getIdCard());
        this.setPhone(user.getPhone());
        this.setEmail(user.getEmail());
        this.setAddress(user.getAddress());
        this.setRole(user.getRole());
    }
}
