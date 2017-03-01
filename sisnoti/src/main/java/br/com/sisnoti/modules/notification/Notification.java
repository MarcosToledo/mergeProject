package br.com.sisnoti.modules.notification;

import java.io.Serializable;
import javax.persistence.*;

import br.com.sisnoti.modules.broker.Broker;
import br.com.sisnoti.modules.client.Client;
import br.com.sisnoti.modules.event.Event;

import java.util.Date;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@Table(name="notification")
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
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

	private String phone;

	@Column(name="visit_status")
	private int visitStatus;

	private String visitor;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Broker
	@ManyToOne
	@JoinColumn(name="id_broker")
	private Broker broker;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="id_event")
	private Event event;

	public Notification() {
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getVisitStatus() {
		return this.visitStatus;
	}

	public void setVisitStatus(int visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getVisitor() {
		return this.visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}