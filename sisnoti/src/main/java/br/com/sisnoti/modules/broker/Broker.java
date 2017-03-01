package br.com.sisnoti.modules.broker;

import java.io.Serializable;
import javax.persistence.*;

import br.com.sisnoti.modules.client.Client;
import br.com.sisnoti.modules.notification.Notification;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the broker database table.
 * 
 */
@Entity
@Table(name="broker")
@NamedQuery(name="Broker.findAll", query="SELECT b FROM Broker b")
public class Broker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte actived;

	private String company;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_register")
	private Date dateRegister;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_update")
	private Date dateUpdate;

	private String name;

	private String phone;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="broker")
	private List<Notification> notifications;

	public Broker() {
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

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setBroker(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setBroker(null);

		return notification;
	}

}