package com.beta.rsatech.churchcradle.client.app.html.admin.popup.member;

import com.beta.rsatech.churchcradle.client.utils.Utils;
import com.beta.rsatech.churchcradle.shared.AppConstants;
import com.beta.rsatech.churchcradle.shared.MemberModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class StageTwo extends Composite implements IsWizardable<MemberModel>{

	private HasWizardEvent<MemberModel> wizardHandler;
	private MemberModel model;
	private boolean isMale, isFemale;
	private static StageTwoUiBinder uiBinder = GWT
			.create(StageTwoUiBinder.class);

	interface StageTwoUiBinder extends UiBinder<Widget, StageTwo> {
	}

	@UiField InputElement maleInput, femaleInput;
	@UiField TextBox occupationField, dobField, employerField;
	@UiField TextArea addressField;
	
	public StageTwo(MemberModel model) {
		this.model = model;
		initWidget(uiBinder.createAndBindUi(this));
		initComponent(model);
		initEvent();
	}
	
	private void initComponent(MemberModel model){
		addressField.getElement().setAttribute("placeholder", "Enter address");
		dobField.getElement().setAttribute("placeholder", "Date of Birth  (yyyy-mm-dd)");
		occupationField.getElement().setAttribute("placeholder", "Job Title");
		employerField.getElement().setAttribute("placeholder", "Company / Institution");
		
		if(model != null){
			addressField.setText(model.getAddress() != null ? model.getAddress() : "");
			dobField.setText(model.getDateOfBirth() != null ? model.getDateOfBirth() : "");
			occupationField.setText(model.getOccupation() != null ? model.getOccupation() : "");
			employerField.setText(model.getEmployer() != null ? model.getEmployer() : "");
			if(model.getGender() != null && model.getGender().equalsIgnoreCase(AppConstants.MALE)){
				enableMaleCheck();
			}else if(model.getGender() != null && model.getGender().equalsIgnoreCase(AppConstants.FEMALE)){
				enableFemaleCheck();
			}
		}
	}
	
	private void enableMaleCheck(){
		maleInput.setAttribute("checked", "");
		isMale = true;
	}
	
	private void enableFemaleCheck(){
		femaleInput.setAttribute("checked", "");
		isFemale = true;
	}
	
	private void initEvent(){
		DOM.sinkEvents(maleInput, Event.ONCLICK);
		DOM.setEventListener(maleInput, new EventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				isMale = true;
				isFemale = false;
			}
		});
		
		DOM.sinkEvents(femaleInput, Event.ONCLICK);
		DOM.setEventListener(femaleInput, new EventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				isFemale = true;
				isMale = false;
			}
		});
	}
	
	@Override
	public void validateAndProceed() {
		if(isMale == false && isFemale == false){
			doPublishError("Please choose a gender");
			return;
		}
		
		if(dobField.getText().trim().isEmpty()){
			doPublishError("Enter date of birth");
			return;
		}
		
		if(!Utils.isDateValid(dobField.getText().trim(), "-")){
			doPublishError("Wrong date");
			return;
		}
		
		if(addressField.getText().trim().isEmpty()){
			doPublishError("Please specify address");
			return;
		}
		
		if(addressField.getText().trim().length() < 5){
			doPublishError("Address is too short");
			return;
		}
		
		doPrepareMemberModel();
		next();
		
	}
	
	public void next(){
		wizardHandler.onValidateComplete(WizardStage.THREE, model);
	}
	
	public void back(){
		wizardHandler.onValidateComplete(WizardStage.ONE, model);
	}
	
	private void doPrepareMemberModel(){
		model.setDateOfBirth(dobField.getText().trim());
		model.setGender(isMale?AppConstants.MALE:AppConstants.FEMALE);
		model.setAddress(addressField.getText().trim());
		model.setOccupation(occupationField.getText().trim());
		model.setEmployer(employerField.getText().trim());
	}
	
	private void doPublishError(String message){
		if(wizardHandler != null){
			wizardHandler.onError(message);
		}
	}

	@Override
	public void setHasWizardEvent(HasWizardEvent<MemberModel> event) {
		this.wizardHandler = event;
	}

	@Override
	public void validateAndReturn() {
		doPrepareMemberModel();
		back();		
	}

}
