package br.com.sisnoti.modules.event;

import java.io.Serializable;
import javax.persistence.*;

import br.com.sisnoti.modules.client.Client;
import br.com.sisnoti.modules.confignotification.ConfigNotification;
import br.com.sisnoti.modules.notification.Notification;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte actived;

	private String address;

	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_register")
	private Date dateRegister;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_update")
	private Date dateUpdate;

	private String name;

	private int number;

	private String uf;

	@Column(name="zip_code")
	private String zipCode;

	//bi-directional many-to-one association to ConfigNotification
	@OneToMany(mappedBy="event")
	private List<ConfigNotification> configNotifications;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="event")
	private List<Notification> notifications;

	public Event() {
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<ConfigNotification> getConfigNotifications() {
		return this.configNotifications;
	}

	public void setConfigNotifications(List<ConfigNotification> configNotifications) {
		this.configNotifications = configNotifications;
	}

	public ConfigNotification addConfigNotification(ConfigNotification configNotification) {
		getConfigNotifications().add(configNotification);
		configNotification.setEvent(this);

		return configNotification;
	}

	public ConfigNotification removeConfigNotification(ConfigNotification configNotification) {
		getConfigNotifications().remove(configNotification);
		configNotification.setEvent(null);

		return configNotification;
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
		notification.setEvent(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setEvent(null);

		return notification;
	}

}