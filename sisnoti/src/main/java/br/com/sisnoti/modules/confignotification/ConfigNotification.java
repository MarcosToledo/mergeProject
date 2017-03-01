package br.com.sisnoti.modules.confignotification;

import java.io.Serializable;
import javax.persistence.*;

import br.com.sisnoti.modules.event.Event;

import java.util.Date;


/**
 * The persistent class for the config_notification database table.
 * 
 */
@Entity
@Table(name="config_notification")
@NamedQuery(name="ConfigNotification.findAll", query="SELECT c FROM ConfigNotification c")
public class ConfigNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte actived;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_register")
	private Date dateRegister;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_update")
	private Date dateUpdate;

	@Column(name="file_name")
	private String fileName;

	private String path;

	private int type;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="id_event")
	private Event event;

	public ConfigNotification() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActived() {
		return this.actived;
	}

	public void setActived(byte actived) {
		this.actived = actived;
	}

	public Date getDateRegister() {
		return this.dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}