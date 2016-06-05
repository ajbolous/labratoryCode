package Controllers;

import models.Clinic;
import models.Examination;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import Client.Application;
import Utils.Request;

public class ExaminationController {

	public static Examination getById(int id) {

		Request r = new Request("examinations/getById");
		r.addParam("sid", id);
		return (Examination) Application.client.sendRequest(r);
	}

	public static Clinic getClinic(int cid) {
		Request r = new Request("clinics/getById");
		r.addParam("cid", cid);
		return (Clinic) Application.client.sendRequest(r);
	}

	public static void saveExamination(Examination ex, ImageIcon ic) {
		Request r = new Request("examinations/update");
		r.addParam("examination", ex);
		r.addParam("image", ic);
		Application.client.sendRequest(r);

	}
}