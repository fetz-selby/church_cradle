package com.beta.rsatech.churchcradle.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MemberModel implements IsSerializable{
	private int id, churchId, billingId, classId, modifiedBy, createdBy, approvedBy;
	private String firstName, password, lastName, email, msisdn, address, dateOfBirth, dateOfCommencement, gender, createdTs, modifiedTs, approveModules, entryModules, organisations, occupation, employer, tithes, status, avatar;
	private boolean isAdmin, canSMS, isUpdate, canViewPayments, isDeleteMember;
	private String oldPassword, otherInfo = "";
	
	public MemberModel(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChurchId() {
		return churchId;
	}

	public void setChurchId(int churchId) {
		this.churchId = churchId;
	}

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(String createdTs) {
		this.createdTs = createdTs;
	}

	public String getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(String modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public String getApproveModules() {
		return approveModules;
	}

	public void setApproveModules(String approveModules) {
		this.approveModules = approveModules;
	}

	public String getOrganisations() {
		return organisations;
	}

	public void setOrganisations(String organisations) {
		this.organisations = organisations;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTithes() {
		return tithes;
	}

	public void setTithes(String tithes) {
		this.tithes = tithes;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isCanSMS() {
		return canSMS;
	}

	public void setCanSMS(boolean canSMS) {
		this.canSMS = canSMS;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEntryModules() {
		return entryModules;
	}

	public void setEntryModules(String entryModules) {
		this.entryModules = entryModules;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean isCanViewPayments() {
		return canViewPayments;
	}

	public void setCanViewPayments(boolean canViewPayments) {
		this.canViewPayments = canViewPayments;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public boolean isDeleteMember() {
		return isDeleteMember;
	}

	public void setDeleteMember(boolean isDeleteMember) {
		this.isDeleteMember = isDeleteMember;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getDateOfCommencement() {
		return dateOfCommencement;
	}

	public void setDateOfCommencement(String dateOfCommencement) {
		this.dateOfCommencement = dateOfCommencement;
	}
	
}
