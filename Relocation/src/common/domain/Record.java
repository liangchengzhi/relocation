package common.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllRecords", query = "select myRecord from Record myRecord"),
		@NamedQuery(name = "findRecordByAwardFee", query = "select myRecord from Record myRecord where myRecord.awardFee = ?1"),
		@NamedQuery(name = "findRecordByBalance1", query = "select myRecord from Record myRecord where myRecord.balance1 = ?1"),
		@NamedQuery(name = "findRecordByBalance2", query = "select myRecord from Record myRecord where myRecord.balance2 = ?1"),
		@NamedQuery(name = "findRecordByBalanceDeal", query = "select myRecord from Record myRecord where myRecord.balanceDeal = ?1"),
		@NamedQuery(name = "findRecordByBankAccount", query = "select myRecord from Record myRecord where myRecord.bankAccount = ?1"),
		@NamedQuery(name = "findRecordByBankAccountContaining", query = "select myRecord from Record myRecord where myRecord.bankAccount like ?1"),
		@NamedQuery(name = "findRecordByBusinessArea", query = "select myRecord from Record myRecord where myRecord.businessArea = ?1"),
		@NamedQuery(name = "findRecordByBusinessAreaBack", query = "select myRecord from Record myRecord where myRecord.businessAreaBack = ?1"),
		@NamedQuery(name = "findRecordByBusinessAreaBackReturn", query = "select myRecord from Record myRecord where myRecord.businessAreaBackReturn = ?1"),
		@NamedQuery(name = "findRecordByBusinessAreaBackRoom", query = "select myRecord from Record myRecord where myRecord.businessAreaBackRoom = ?1"),
		@NamedQuery(name = "findRecordByBusinessAreaBackRoomContaining", query = "select myRecord from Record myRecord where myRecord.businessAreaBackRoom like ?1"),
		@NamedQuery(name = "findRecordByContractNumber", query = "select myRecord from Record myRecord where myRecord.contractNumber = ?1"),
		@NamedQuery(name = "findRecordByContractNumberContaining", query = "select myRecord from Record myRecord where myRecord.contractNumber like ?1"),
		@NamedQuery(name = "findRecordByCoveredArea", query = "select myRecord from Record myRecord where myRecord.coveredArea = ?1"),
		@NamedQuery(name = "findRecordByCoveredAreaBack", query = "select myRecord from Record myRecord where myRecord.coveredAreaBack = ?1"),
		@NamedQuery(name = "findRecordByCreatedTime", query = "select myRecord from Record myRecord where myRecord.createdTime = ?1"),
		@NamedQuery(name = "findRecordByDeletedTime", query = "select myRecord from Record myRecord where myRecord.deletedTime = ?1"),
		@NamedQuery(name = "findRecordByDiscontinuedFee", query = "select myRecord from Record myRecord where myRecord.discontinuedFee = ?1"),
		@NamedQuery(name = "findRecordByEndTime", query = "select myRecord from Record myRecord where myRecord.endTime = ?1"),
		@NamedQuery(name = "findRecordByFacilityFee", query = "select myRecord from Record myRecord where myRecord.facilityFee = ?1"),
		@NamedQuery(name = "findRecordByHouseArea", query = "select myRecord from Record myRecord where myRecord.houseArea = ?1"),
		@NamedQuery(name = "findRecordByHouseAreaBack", query = "select myRecord from Record myRecord where myRecord.houseAreaBack = ?1"),
		@NamedQuery(name = "findRecordByHouseAreaBackReturn", query = "select myRecord from Record myRecord where myRecord.houseAreaBackReturn = ?1"),
		@NamedQuery(name = "findRecordByHouseAreaBackRoom", query = "select myRecord from Record myRecord where myRecord.houseAreaBackRoom = ?1"),
		@NamedQuery(name = "findRecordByHouseAreaBackRoomContaining", query = "select myRecord from Record myRecord where myRecord.houseAreaBackRoom like ?1"),
		@NamedQuery(name = "findRecordById", query = "select myRecord from Record myRecord where myRecord.id = ?1"),
		@NamedQuery(name = "findRecordByIsDealed", query = "select myRecord from Record myRecord where myRecord.isDealed = ?1"),
		@NamedQuery(name = "findRecordByIsDeleted", query = "select myRecord from Record myRecord where myRecord.isDeleted = ?1"),
		@NamedQuery(name = "findRecordByIsEnd", query = "select myRecord from Record myRecord where myRecord.isEnd = ?1"),
		@NamedQuery(name = "findRecordByIsStart", query = "select myRecord from Record myRecord where myRecord.isStart = ?1"),
		@NamedQuery(name = "findRecordByLastComputeTime", query = "select myRecord from Record myRecord where myRecord.lastComputeTime = ?1"),
		@NamedQuery(name = "findRecordByLastDealTime", query = "select myRecord from Record myRecord where myRecord.lastDealTime = ?1"),
		@NamedQuery(name = "findRecordByLastEditTime", query = "select myRecord from Record myRecord where myRecord.lastEditTime = ?1"),
		@NamedQuery(name = "findRecordByMovingFee", query = "select myRecord from Record myRecord where myRecord.movingFee = ?1"),
		@NamedQuery(name = "findRecordByOtherFee", query = "select myRecord from Record myRecord where myRecord.otherFee = ?1"),
		@NamedQuery(name = "findRecordByPerFee", query = "select myRecord from Record myRecord where myRecord.perFee = ?1"),
		@NamedQuery(name = "findRecordByPrimaryKey", query = "select myRecord from Record myRecord where myRecord.id = ?1"),
		@NamedQuery(name = "findRecordByProductionArea", query = "select myRecord from Record myRecord where myRecord.productionArea = ?1"),
		@NamedQuery(name = "findRecordByProductionAreaBack", query = "select myRecord from Record myRecord where myRecord.productionAreaBack = ?1"),
		@NamedQuery(name = "findRecordByProductionAreaBackReturn", query = "select myRecord from Record myRecord where myRecord.productionAreaBackReturn = ?1"),
		@NamedQuery(name = "findRecordByProductionAreaBackRoom", query = "select myRecord from Record myRecord where myRecord.productionAreaBackRoom = ?1"),
		@NamedQuery(name = "findRecordByProductionAreaBackRoomContaining", query = "select myRecord from Record myRecord where myRecord.productionAreaBackRoom like ?1"),
		@NamedQuery(name = "findRecordByProductionAreaContaining", query = "select myRecord from Record myRecord where myRecord.productionArea like ?1"),
		@NamedQuery(name = "findRecordByProjectName", query = "select myRecord from Record myRecord where myRecord.projectName = ?1"),
		@NamedQuery(name = "findRecordByProjectNameContaining", query = "select myRecord from Record myRecord where myRecord.projectName like ?1"),
		@NamedQuery(name = "findRecordByRecordNumber", query = "select myRecord from Record myRecord where myRecord.recordNumber = ?1"),
		@NamedQuery(name = "findRecordByRecordNumberContaining", query = "select myRecord from Record myRecord where myRecord.recordNumber like ?1"),
		@NamedQuery(name = "findRecordByRemark", query = "select myRecord from Record myRecord where myRecord.remark = ?1"),
		@NamedQuery(name = "findRecordBySelfRemoveAmount", query = "select myRecord from Record myRecord where myRecord.selfRemoveAmount = ?1"),
		@NamedQuery(name = "findRecordBySelfRemoveAmountContaining", query = "select myRecord from Record myRecord where myRecord.selfRemoveAmount like ?1"),
		@NamedQuery(name = "findRecordBySelfRemoveArea", query = "select myRecord from Record myRecord where myRecord.selfRemoveArea = ?1"),
		@NamedQuery(name = "findRecordBySelfRemoveAreaContaining", query = "select myRecord from Record myRecord where myRecord.selfRemoveArea like ?1"),
		@NamedQuery(name = "findRecordBySelfSimplyArea", query = "select myRecord from Record myRecord where myRecord.selfSimplyArea = ?1"),
		@NamedQuery(name = "findRecordBySelfSimplyAreaContaining", query = "select myRecord from Record myRecord where myRecord.selfSimplyArea like ?1"),
		@NamedQuery(name = "findRecordBySelfdemolitionFee", query = "select myRecord from Record myRecord where myRecord.selfdemolitionFee = ?1"),
		@NamedQuery(name = "findRecordByStartDealTime", query = "select myRecord from Record myRecord where myRecord.startDealTime = ?1"),
		@NamedQuery(name = "findRecordByStartTime", query = "select myRecord from Record myRecord where myRecord.startTime = ?1"),
		@NamedQuery(name = "findRecordByTotal", query = "select myRecord from Record myRecord where myRecord.total = ?1"),
		@NamedQuery(name = "findRecordByTransitionFee", query = "select myRecord from Record myRecord where myRecord.transitionFee = ?1"),
		@NamedQuery(name = "findRecordByTransportFee", query = "select myRecord from Record myRecord where myRecord.transportFee = ?1"),
		@NamedQuery(name = "findRecordByUseraddress", query = "select myRecord from Record myRecord where myRecord.useraddress = ?1"),
		@NamedQuery(name = "findRecordByUseraddressContaining", query = "select myRecord from Record myRecord where myRecord.useraddress like ?1"),
		@NamedQuery(name = "findRecordByUsercontact", query = "select myRecord from Record myRecord where myRecord.usercontact = ?1"),
		@NamedQuery(name = "findRecordByUsercontactContaining", query = "select myRecord from Record myRecord where myRecord.usercontact like ?1"),
		@NamedQuery(name = "findRecordByUseridcard", query = "select myRecord from Record myRecord where myRecord.useridcard = ?1"),
		@NamedQuery(name = "findRecordByUseridcardContaining", query = "select myRecord from Record myRecord where myRecord.useridcard like ?1"),
		@NamedQuery(name = "findRecordByUsername", query = "select myRecord from Record myRecord where myRecord.username = ?1"),
		@NamedQuery(name = "findRecordByUsernameContaining", query = "select myRecord from Record myRecord where myRecord.username like ?1"),
		@NamedQuery(name = "findRecordByReplaceFlag", query = "select myRecord from Record myRecord where myRecord.replaceFlag = ?1")})
@Table(catalog = "relocation", name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Record")
@XmlRootElement(namespace = "Relocation/common/domain")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;



	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "project_name")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String projectName;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "first_start_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar firstStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "first_end_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar firstEndTime;

	@Column(name = "username")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;


	@Column(name = "usercontact")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String usercontact;


	@Column(name = "useraddress")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String useraddress;

	@Column(name = "useridcard")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String useridcard;


	@Column(name = "contract_number")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contractNumber;

	@Column(name = "record_number")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String recordNumber;

	@Column(name = "covered_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal coveredArea;


	@Column(name = "covered_area_back", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal coveredAreaBack;


	@Column(name = "house_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal houseArea;
	

	@Column(name = "house_area_back", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal houseAreaBack;


	@Column(name = "house_area_back_return", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal houseAreaBackReturn;


	@Column(name = "house_area_back_room")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String houseAreaBackRoom;


	@Column(name = "business_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal businessArea;


	@Column(name = "business_area_back", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal businessAreaBack;


	@Column(name = "business_area_back_return", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal businessAreaBackReturn;


	@Column(name = "business_area_back_room")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String businessAreaBackRoom;

	@Column(name = "production_area")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String productionArea;


	@Column(name = "production_area_back", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal productionAreaBack;


	@Column(name = "production_area_back_return", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal productionAreaBackReturn;

	@Column(name = "production_area_back_room")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String productionAreaBackRoom;
	
	/**
	 *  实际还住宅房面积
	 */
	@Column(name = "actual_back_house_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal actualBackHouseArea;
	
	/**
	 *  实际还营业房面积
	 */
	@Column(name = "actual_back_business_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal actualBackBusinessArea;
	
	
	

	@Column(name = "over_area")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String overArea;
	

	@Column(name = "over_area_business")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String overAreaBusiness;

	@Column(name = "other_area")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String otherArea;

	@Column(name = "pending_state")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String pendingState;

	@Column(name = "replace_flag", scale = 0, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer replaceFlag;

	@Column(name = "replace_business_area_before", scale = 2, precision = 1)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceBusinessAreaBefore;
	
	@Column(name = "replace_house_area_before", scale = 2, precision = 1)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceHouseAreaBefore;
	
	@Column(name = "replace_business_area", scale = 2, precision = 1)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceBusinessArea;
	
	@Column(name = "replace_house_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceHouseArea;
	
	@Column(name = "replace_area_total", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceAreaTotal;
	
	@Column(name = "replace_business_ratio", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceBusinessRatio;
	
	@Column(name = "replace_house_ratio", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal replaceHouseRatio;


	@Column(name = "balance1", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal balance1;


	@Column(name = "balance2", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal balance2;


	@Column(name = "balance_deal", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal balanceDeal;


	@Column(name = "bank_account")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String bankAccount;

	@Column(name = "self_remove_area")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selfRemoveArea;


	@Column(name = "self_simply_area")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selfSimplyArea;

	@Column(name = "self_remove_amount")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selfRemoveAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_deal_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDealTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_deal_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastDealTime;


	@Column(name = "is_dealed")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDealed;


	@Column(name = "remark")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String remark;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endTime;


	@Column(name = "is_start")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isStart;

	@Column(name = "is_end")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_edit_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastEditTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar deletedTime;


	@Column(name = "is_deleted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDeleted;
	
	
	/**
	 *  100 平米优惠
	 */
	@Column(name = "area_benefit_100")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean areaBenefit100;


	@Column(name = "facility_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal facilityFee;


	@Column(name = "transport_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal transportFee;


	@Column(name = "transition_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal transitionFee;


	@Column(name = "moving_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal movingFee;


	@Column(name = "award_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal awardFee;


	@Column(name = "discontinued_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal discontinuedFee;


	@Column(name = "selfdemolition_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal selfdemolitionFee;


	@Column(name = "other_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal otherFee;


	@Column(name = "total", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal total;

	/**
	 *  数据渠道
	 *  0:交易录入
	 *  1:导入
	 */
	@Column(name = "channel")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String channel;
	
	
	/**
	 *  原项目编号(暂用于导入拆迁记录)
	 */
	@Column(name = "old_project_no")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String oldProjectNo;
	
	/**
	 *  信息ID(记录一个人信息的标识，将来补全这条信息用到)
	 */
	@Column(name = "info_id")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String infoId;
	
	/**
	 *  住宅房拟还房信息
	 */
	@Column(name = "plan_return_house_info")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String planReturnHouseInfo;
	
	/**
	 *  营业房拟还房信息
	 */
	@Column(name = "plan_return_business_info")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String planReturnBusinessInfo;
	

	@Column(name = "per_fee", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal perFee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_compute_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastComputeTime;
	
	
	/**
	 *  暂停计算过渡费(1是0否默认为否)
	 */
	@Column(name = "pause_calculate_fee")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	boolean pauseCalculateFee;
	/**
	 *  办事处管理（01-新蒲办、02-新中办、03-指挥部）
	 */
	@Column(name = "service_department")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String serviceDepartment;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "uid", referencedColumnName = "id") })
	@XmlTransient
	Cuser cuser;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "pid", referencedColumnName = "id") })
	@XmlTransient
	Project project;
	/**
	 */
	@OneToMany(mappedBy = "record", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<common.domain.RecordTransitionfee> recordTransitionfees;
	
	

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 锟斤拷目锟斤拷锟�
	 * 
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 锟斤拷目锟斤拷锟�
	 * 
	 */
	public String getProjectName() {
		return this.projectName;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷锟斤拷锟斤拷
	 * 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * 
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷锟斤拷系锟斤拷式
	 * 
	 */
	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷锟斤拷系锟斤拷式
	 * 
	 */
	public String getUsercontact() {
		return this.usercontact;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷锟斤拷址
	 * 
	 */
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷锟斤拷址
	 * 
	 */
	public String getUseraddress() {
		return this.useraddress;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷省锟捷憋拷识锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街わ拷锟�
	 * 
	 */
	public void setUseridcard(String useridcard) {
		this.useridcard = useridcard;
	}

	/**
	 * 锟斤拷锟斤拷迁锟矫伙拷省锟捷憋拷识锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街わ拷锟�
	 * 
	 */
	public String getUseridcard() {
		return this.useridcard;
	}

	/**
	 * 锟斤拷同锟斤拷锟�
	 * 
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	/**
	 * 锟斤拷同锟斤拷锟�
	 * 
	 */
	public String getContractNumber() {
		return this.contractNumber;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * 
	 */
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * 
	 */
	public String getRecordNumber() {
		return this.recordNumber;
	}

	/**
	 * 锟斤拷锟捷斤拷锟斤拷锟斤拷锟叫★拷疲锟斤拷O锟斤拷
	 * 
	 */
	public void setCoveredArea(BigDecimal coveredArea) {
		this.coveredArea = coveredArea;
	}

	/**
	 * 锟斤拷锟捷斤拷锟斤拷锟斤拷锟叫★拷疲锟斤拷O锟斤拷
	 * 
	 */
	public BigDecimal getCoveredArea() {
		return this.coveredArea;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟捷斤拷锟斤拷锟斤拷锟叫★拷疲锟斤拷O锟斤拷
	 * 
	 */
	public void setCoveredAreaBack(BigDecimal coveredAreaBack) {
		this.coveredAreaBack = coveredAreaBack;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟捷斤拷锟斤拷锟斤拷锟叫★拷疲锟斤拷O锟斤拷
	 * 
	 */
	public BigDecimal getCoveredAreaBack() {
		return this.coveredAreaBack;
	}

	/**
	 * 住宅锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	/**
	 * 住宅锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public BigDecimal getHouseArea() {
		return this.houseArea;
	}

	/**
	 * 锟斤拷锟斤拷住宅锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public void setHouseAreaBack(BigDecimal houseAreaBack) {
		this.houseAreaBack = houseAreaBack;
	}

	/**
	 * 锟斤拷锟斤拷住宅锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public BigDecimal getHouseAreaBack() {
		return this.houseAreaBack;
	}

	/**
	 * 住宅锟斤拷锟杰伙拷锟斤拷锟�
	 * 
	 */
	public void setHouseAreaBackReturn(BigDecimal houseAreaBackReturn) {
		this.houseAreaBackReturn = houseAreaBackReturn;
	}

	/**
	 * 住宅锟斤拷锟杰伙拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getHouseAreaBackReturn() {
		return this.houseAreaBackReturn;
	}

	/**
	 * 锟斤拷锟斤拷住宅锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public void setHouseAreaBackRoom(String houseAreaBackRoom) {
		this.houseAreaBackRoom = houseAreaBackRoom;
	}

	/**
	 * 锟斤拷锟斤拷住宅锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public String getHouseAreaBackRoom() {
		return this.houseAreaBackRoom;
	}

	/**
	 * 营业锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public void setBusinessArea(BigDecimal businessArea) {
		this.businessArea = businessArea;
	}

	/**
	 * 营业锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public BigDecimal getBusinessArea() {
		return this.businessArea;
	}

	/**
	 * 锟斤拷锟斤拷营业锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public void setBusinessAreaBack(BigDecimal businessAreaBack) {
		this.businessAreaBack = businessAreaBack;
	}

	/**
	 * 锟斤拷锟斤拷营业锟斤拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public BigDecimal getBusinessAreaBack() {
		return this.businessAreaBack;
	}

	/**
	 * 锟斤拷业锟斤拷锟杰伙拷锟斤拷锟�
	 * 
	 */
	public void setBusinessAreaBackReturn(BigDecimal businessAreaBackReturn) {
		this.businessAreaBackReturn = businessAreaBackReturn;
	}

	/**
	 * 锟斤拷业锟斤拷锟杰伙拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getBusinessAreaBackReturn() {
		return this.businessAreaBackReturn;
	}

	/**
	 * 锟斤拷锟斤拷营业锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public void setBusinessAreaBackRoom(String businessAreaBackRoom) {
		this.businessAreaBackRoom = businessAreaBackRoom;
	}

	/**
	 * 锟斤拷锟斤拷营业锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public String getBusinessAreaBackRoom() {
		return this.businessAreaBackRoom;
	}

	/**
	 * 锟解房锟斤拷锟斤拷锟斤拷梅锟斤拷锟斤拷O锟斤拷
	 * 
	 */
	public void setProductionArea(String productionArea) {
		this.productionArea = productionArea;
	}

	/**
	 * 锟解房锟斤拷锟斤拷锟斤拷梅锟斤拷锟斤拷O锟斤拷
	 * 
	 */
	public String getProductionArea() {
		return this.productionArea;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷梅锟斤拷锟斤拷O锟斤拷
	 * 
	 */
	public void setProductionAreaBack(BigDecimal productionAreaBack) {
		this.productionAreaBack = productionAreaBack;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷梅锟斤拷锟斤拷O锟斤拷
	 * 
	 */
	public BigDecimal getProductionAreaBack() {
		return this.productionAreaBack;
	}

	/**
	 * 锟斤拷锟阶凤拷锟杰伙拷锟斤拷锟�
	 * 
	 */
	public void setProductionAreaBackReturn(BigDecimal productionAreaBackReturn) {
		this.productionAreaBackReturn = productionAreaBackReturn;
	}

	/**
	 * 锟斤拷锟阶凤拷锟杰伙拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getProductionAreaBackReturn() {
		return this.productionAreaBackReturn;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷梅锟斤拷锟斤拷锟�
	 * 
	 */
	public void setProductionAreaBackRoom(String productionAreaBackRoom) {
		this.productionAreaBackRoom = productionAreaBackRoom;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷梅锟斤拷锟斤拷锟�
	 * 
	 */
	public String getProductionAreaBackRoom() {
		return this.productionAreaBackRoom;
	}

	public String getOverArea() {
		return overArea;
	}

	public void setOverArea(String overArea) {
		this.overArea = overArea;
	}

	public String getOverAreaBusiness() {
		return overAreaBusiness;
	}

	public void setOverAreaBusiness(String overAreaBusiness) {
		this.overAreaBusiness = overAreaBusiness;
	}

	public String getOtherArea() {
		return otherArea;
	}

	public void setOtherArea(String otherArea) {
		this.otherArea = otherArea;
	}

	public String getPendingState() {
		return pendingState;
	}

	public void setPendingState(String pendingState) {
		this.pendingState = pendingState;
	}

	public Integer getReplaceFlag() {
		return replaceFlag;
	}

	public void setReplaceFlag(Integer replaceFlag) {
		this.replaceFlag = replaceFlag;
	}

	public BigDecimal getReplaceBusinessAreaBefore() {
		return replaceBusinessAreaBefore;
	}

	public void setReplaceBusinessAreaBefore(BigDecimal replaceBusinessAreaBefore) {
		this.replaceBusinessAreaBefore = replaceBusinessAreaBefore;
	}

	public BigDecimal getReplaceHouseAreaBefore() {
		return replaceHouseAreaBefore;
	}

	public void setReplaceHouseAreaBefore(BigDecimal replaceHouseAreaBefore) {
		this.replaceHouseAreaBefore = replaceHouseAreaBefore;
	}

	public BigDecimal getReplaceBusinessArea() {
		return replaceBusinessArea;
	}

	public void setReplaceBusinessArea(BigDecimal replaceBusinessArea) {
		this.replaceBusinessArea = replaceBusinessArea;
	}

	public BigDecimal getReplaceHouseArea() {
		return replaceHouseArea;
	}

	public void setReplaceHouseArea(BigDecimal replaceHouseArea) {
		this.replaceHouseArea = replaceHouseArea;
	}

	public BigDecimal getReplaceAreaTotal() {
		return replaceAreaTotal;
	}

	public void setReplaceAreaTotal(BigDecimal replaceAreaTotal) {
		this.replaceAreaTotal = replaceAreaTotal;
	}

	public BigDecimal getReplaceBusinessRatio() {
		return replaceBusinessRatio;
	}

	public void setReplaceBusinessRatio(BigDecimal replaceBusinessRatio) {
		this.replaceBusinessRatio = replaceBusinessRatio;
	}

	public BigDecimal getReplaceHouseRatio() {
		return replaceHouseRatio;
	}

	public void setReplaceHouseRatio(BigDecimal replaceHouseRatio) {
		this.replaceHouseRatio = replaceHouseRatio;
	}

	/**
	 * 锟斤拷锟矫诧拷锟斤拷锟斤拷锟�
	 * 
	 */
	public void setBalance1(BigDecimal balance1) {
		this.balance1 = balance1;
	}

	/**
	 * 锟斤拷锟矫诧拷锟斤拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getBalance1() {
		return this.balance1;
	}

	/**
	 * 锟斤拷锟斤拷迁锟剿诧拷锟斤拷锟斤拷锟�
	 * 
	 */
	public void setBalance2(BigDecimal balance2) {
		this.balance2 = balance2;
	}

	/**
	 * 锟斤拷锟斤拷迁锟剿诧拷锟斤拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getBalance2() {
		return this.balance2;
	}

	/**
	 * 锟窖达拷锟斤拷墓锟缴凤拷锟杰猴拷
	 * 
	 */
	public void setBalanceDeal(BigDecimal balanceDeal) {
		this.balanceDeal = balanceDeal;
	}

	/**
	 * 锟窖达拷锟斤拷墓锟缴凤拷锟杰猴拷
	 * 
	 */
	public BigDecimal getBalanceDeal() {
		return this.balanceDeal;
	}

	/**
	 * 锟斤拷锟斤拷锟剿伙拷
	 * 
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * 锟斤拷锟斤拷锟剿伙拷
	 * 
	 */
	public String getBankAccount() {
		return this.bankAccount;
	}

	/**
	 * 锟皆诧拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public void setSelfRemoveArea(String selfRemoveArea) {
		this.selfRemoveArea = selfRemoveArea;
	}

	/**
	 * 锟皆诧拷锟斤拷锟絆锟斤拷
	 * 
	 */
	public String getSelfRemoveArea() {
		return this.selfRemoveArea;
	}

	/**
	 * 锟皆诧拷锟斤拷追锟斤拷锟斤拷O锟斤拷
	 * 
	 */
	public void setSelfSimplyArea(String selfSimplyArea) {
		this.selfSimplyArea = selfSimplyArea;
	}

	/**
	 * 锟皆诧拷锟斤拷追锟斤拷锟斤拷O锟斤拷
	 * 
	 */
	public String getSelfSimplyArea() {
		return this.selfSimplyArea;
	}

	/**
	 * 锟皆诧拷锟筋（元锟斤拷
	 * 
	 */
	public void setSelfRemoveAmount(String selfRemoveAmount) {
		this.selfRemoveAmount = selfRemoveAmount;
	}

	/**
	 * 锟皆诧拷锟筋（元锟斤拷
	 * 
	 */
	public String getSelfRemoveAmount() {
		return this.selfRemoveAmount;
	}

	/**
	 * 锟斤拷始锟斤拷锟绞憋拷锟�
	 * 
	 */
	public void setStartDealTime(Calendar startDealTime) {
		this.startDealTime = startDealTime;
	}

	/**
	 * 锟斤拷始锟斤拷锟绞憋拷锟�
	 * 
	 */
	public Calendar getStartDealTime() {
		return this.startDealTime;
	}

	/**
	 * 锟斤拷锟揭伙拷畏锟斤拷殴锟缴凤拷
	 * 
	 */
	public void setLastDealTime(Calendar lastDealTime) {
		this.lastDealTime = lastDealTime;
	}

	/**
	 * 锟斤拷锟揭伙拷畏锟斤拷殴锟缴凤拷
	 * 
	 */
	public Calendar getLastDealTime() {
		return this.lastDealTime;
	}

	/**
	 * 1锟斤拷示锟斤拷前锟窖癸拷锟�
	 * 
	 */
	public void setIsDealed(Boolean isDealed) {
		this.isDealed = isDealed;
	}

	/**
	 * 1锟斤拷示锟斤拷前锟窖癸拷锟�
	 * 
	 */
	public Boolean getIsDealed() {
		return this.isDealed;
	}

	/**
	 * 锟斤拷注
	 * 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 锟斤拷注
	 * 
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 锟斤拷同锟斤拷始时锟戒（锟斤拷锟斤拷时锟戒）
	 * 
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * 锟斤拷同锟斤拷始时锟戒（锟斤拷锟斤拷时锟戒）
	 * 
	 */
	public Calendar getStartTime() {
		return this.startTime;
	}

	/**
	 * 锟斤拷同锟斤拷锟斤拷时锟戒（锟斤拷锟斤拷时锟戒）
	 * 
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	/**
	 * 锟斤拷同锟斤拷锟斤拷时锟戒（锟斤拷锟斤拷时锟戒）
	 * 
	 */
	public Calendar getEndTime() {
		return this.endTime;
	}

	/**
	 * 1锟斤拷示锟窖帮拷迁
	 * 
	 */
	public void setIsStart(Boolean isStart) {
		this.isStart = isStart;
	}

	/**
	 * 1锟斤拷示锟窖帮拷迁
	 * 
	 */
	public Boolean getIsStart() {
		return this.isStart;
	}

	/**
	 * 1锟斤拷示锟窖伙拷锟斤拷
	 * 
	 */
	public void setIsEnd(Boolean isEnd) {
		this.isEnd = isEnd;
	}

	/**
	 * 1锟斤拷示锟窖伙拷锟斤拷
	 * 
	 */
	public Boolean getIsEnd() {
		return this.isEnd;
	}

	/**
	 * 锟筋报时锟斤拷
	 * 
	 */
	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * 锟筋报时锟斤拷
	 * 
	 */
	public Calendar getCreatedTime() {
		return this.createdTime;
	}

	/**
	 * 锟斤拷锟洁辑时锟斤拷
	 * 
	 */
	public void setLastEditTime(Calendar lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	/**
	 * 锟斤拷锟洁辑时锟斤拷
	 * 
	 */
	public Calendar getLastEditTime() {
		return this.lastEditTime;
	}

	/**
	 * 删锟斤拷时锟斤拷
	 * 
	 */
	public void setDeletedTime(Calendar deletedTime) {
		this.deletedTime = deletedTime;
	}

	/**
	 * 删锟斤拷时锟斤拷
	 * 
	 */
	public Calendar getDeletedTime() {
		return this.deletedTime;
	}

	/**
	 * 1锟斤拷示锟斤拷删锟斤拷
	 * 
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 1锟斤拷示锟斤拷删锟斤拷
	 * 
	 */
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷施锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public void setFacilityFee(BigDecimal facilityFee) {
		this.facilityFee = facilityFee;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷施锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public BigDecimal getFacilityFee() {
		return this.facilityFee;
	}

	/**
	 * 锟斤拷通锟斤拷
	 * 
	 */
	public void setTransportFee(BigDecimal transportFee) {
		this.transportFee = transportFee;
	}

	/**
	 * 锟斤拷通锟斤拷
	 * 
	 */
	public BigDecimal getTransportFee() {
		return this.transportFee;
	}

	/**
	 * 锟斤拷煞锟�
	 * 
	 */
	public void setTransitionFee(BigDecimal transitionFee) {
		this.transitionFee = transitionFee;
	}

	/**
	 * 锟斤拷煞锟�
	 * 
	 */
	public BigDecimal getTransitionFee() {
		return this.transitionFee;
	}

	/**
	 * 锟斤拷曳锟�
	 * 
	 */
	public void setMovingFee(BigDecimal movingFee) {
		this.movingFee = movingFee;
	}

	/**
	 * 锟斤拷曳锟�
	 * 
	 */
	public BigDecimal getMovingFee() {
		return this.movingFee;
	}

	/**
	 * 锟斤拷锟斤拷
	 * 
	 */
	public void setAwardFee(BigDecimal awardFee) {
		this.awardFee = awardFee;
	}

	/**
	 * 锟斤拷锟斤拷
	 * 
	 */
	public BigDecimal getAwardFee() {
		return this.awardFee;
	}

	/**
	 * 停锟斤拷停业锟斤拷锟斤拷
	 * 
	 */
	public void setDiscontinuedFee(BigDecimal discontinuedFee) {
		this.discontinuedFee = discontinuedFee;
	}

	/**
	 * 停锟斤拷停业锟斤拷锟斤拷
	 * 
	 */
	public BigDecimal getDiscontinuedFee() {
		return this.discontinuedFee;
	}

	/**
	 * 锟皆诧拷锟斤拷锟�
	 * 
	 */
	public void setSelfdemolitionFee(BigDecimal selfdemolitionFee) {
		this.selfdemolitionFee = selfdemolitionFee;
	}

	/**
	 * 锟皆诧拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getSelfdemolitionFee() {
		return this.selfdemolitionFee;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * 
	 */
	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getOtherFee() {
		return this.otherFee;
	}

	/**
	 * 锟斤拷锟较硷拷
	 * 
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * 锟斤拷锟较硷拷
	 * 
	 */
	public BigDecimal getTotal() {
		return this.total;
	}

	/**
	 * 锟斤拷锟斤拷芊鸭锟斤拷锟斤拷每锟斤拷锟斤拷锟�
	 * 
	 */
	public void setPerFee(BigDecimal perFee) {
		this.perFee = perFee;
	}

	/**
	 * 锟斤拷锟斤拷芊鸭锟斤拷锟斤拷每锟斤拷锟斤拷锟�
	 * 
	 */
	public BigDecimal getPerFee() {
		return this.perFee;
	}

	/**
	 * 锟较次癸拷煞鸭锟斤拷锟绞憋拷锟�
	 * 
	 */
	public void setLastComputeTime(Calendar lastComputeTime) {
		this.lastComputeTime = lastComputeTime;
	}

	/**
	 * 锟较次癸拷煞鸭锟斤拷锟绞憋拷锟�
	 * 
	 */
	public Calendar getLastComputeTime() {
		return this.lastComputeTime;
	}
	
	public void setFirstEndTime(Calendar firstEndTime) {
		this.firstEndTime = firstEndTime;
	}
	public Calendar getFirstEndTime() {
		return firstEndTime;
	}
	public void setFirstStartTime(Calendar firstStartTime) {
		this.firstStartTime = firstStartTime;
	}
	public Calendar getFirstStartTime() {
		return firstStartTime;
	}
	
	
	public BigDecimal getActualBackHouseArea() {
		return actualBackHouseArea;
	}

	public void setActualBackHouseArea(BigDecimal actualBackHouseArea) {
		this.actualBackHouseArea = actualBackHouseArea;
	}

	public BigDecimal getActualBackBusinessArea() {
		return actualBackBusinessArea;
	}

	public void setActualBackBusinessArea(BigDecimal actualBackBusinessArea) {
		this.actualBackBusinessArea = actualBackBusinessArea;
	}
	

	public Boolean getAreaBenefit100() {
		return areaBenefit100;
	}

	public void setAreaBenefit100(Boolean areaBenefit100) {
		this.areaBenefit100 = areaBenefit100;
	}
	
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOldProjectNo() {
		return oldProjectNo;
	}

	public void setOldProjectNo(String oldProjectNo) {
		this.oldProjectNo = oldProjectNo;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	
	public boolean isPauseCalculateFee() {
		return pauseCalculateFee;
	}

	public void setPauseCalculateFee(boolean pauseCalculateFee) {
		this.pauseCalculateFee = pauseCalculateFee;
	}

	public String getPlanReturnHouseInfo() {
		return planReturnHouseInfo;
	}

	public void setPlanReturnHouseInfo(String planReturnHouseInfo) {
		this.planReturnHouseInfo = planReturnHouseInfo;
	}

	public String getPlanReturnBusinessInfo() {
		return planReturnBusinessInfo;
	}

	public void setPlanReturnBusinessInfo(String planReturnBusinessInfo) {
		this.planReturnBusinessInfo = planReturnBusinessInfo;
	}

	public String getServiceDepartment() {
		return serviceDepartment;
	}

	public void setServiceDepartment(String serviceDepartment) {
		this.serviceDepartment = serviceDepartment;
	}

	/**
	 */
	public void setCuser(Cuser cuser) {
		this.cuser = cuser;
	}

	/**
	 */
	@JsonIgnore
	public Cuser getCuser() {
		return cuser;
	}

	/**
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 */
	@JsonIgnore
	public Project getProject() {
		return project;
	}

	/**
	 */
	public void setRecordTransitionfees(Set<RecordTransitionfee> recordTransitionfees) {
		this.recordTransitionfees = recordTransitionfees;
	}
	
	/**
	 */
	@JsonIgnore
	public Set<RecordTransitionfee> getRecordTransitionfees() {
		if (recordTransitionfees == null) {
			recordTransitionfees = new java.util.LinkedHashSet<common.domain.RecordTransitionfee>();
		}
		return recordTransitionfees;
	}

	/**
	 */
	public Record() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Record that) {
		setId(that.getId());
		setProjectName(that.getProjectName());
		setUsername(that.getUsername());
		setUsercontact(that.getUsercontact());
		setUseraddress(that.getUseraddress());
		setUseridcard(that.getUseridcard());
		setContractNumber(that.getContractNumber());
		setRecordNumber(that.getRecordNumber());
		setCoveredArea(that.getCoveredArea());
		setCoveredAreaBack(that.getCoveredAreaBack());
		setHouseArea(that.getHouseArea());
		setHouseAreaBack(that.getHouseAreaBack());
		setHouseAreaBackReturn(that.getHouseAreaBackReturn());
		setHouseAreaBackRoom(that.getHouseAreaBackRoom());
		setBusinessArea(that.getBusinessArea());
		setBusinessAreaBack(that.getBusinessAreaBack());
		setBusinessAreaBackReturn(that.getBusinessAreaBackReturn());
		setBusinessAreaBackRoom(that.getBusinessAreaBackRoom());
		setProductionArea(that.getProductionArea());
		setProductionAreaBack(that.getProductionAreaBack());
		setProductionAreaBackReturn(that.getProductionAreaBackReturn());
		setProductionAreaBackRoom(that.getProductionAreaBackRoom());
		setOverArea(that.getOverArea());
		setOverAreaBusiness(that.getOverAreaBusiness());
		setOtherArea(that.getOtherArea());
		setPendingState(that.getPendingState());
		setReplaceFlag(that.getReplaceFlag());
		setReplaceBusinessAreaBefore(that.getReplaceBusinessAreaBefore());
		setReplaceHouseAreaBefore(that.getReplaceBusinessAreaBefore());
		setReplaceBusinessArea(that.getBusinessArea());
		setReplaceHouseArea(that.getReplaceHouseArea());
		setReplaceAreaTotal(that.getReplaceAreaTotal());
		setReplaceBusinessRatio(that.getReplaceBusinessRatio());
		setReplaceHouseRatio(that.getReplaceHouseRatio());
		setBalance1(that.getBalance1());
		setBalance2(that.getBalance2());
		setBalanceDeal(that.getBalanceDeal());
		setBankAccount(that.getBankAccount());
		setSelfRemoveArea(that.getSelfRemoveArea());
		setSelfSimplyArea(that.getSelfSimplyArea());
		setSelfRemoveAmount(that.getSelfRemoveAmount());
		setStartDealTime(that.getStartDealTime());
		setLastDealTime(that.getLastDealTime());
		setIsDealed(that.getIsDealed());
		setRemark(that.getRemark());
		setStartTime(that.getStartTime());
		setEndTime(that.getEndTime());
		setIsStart(that.getIsStart());
		setIsEnd(that.getIsEnd());
		setCreatedTime(that.getCreatedTime());
		setLastEditTime(that.getLastEditTime());
		setDeletedTime(that.getDeletedTime());
		setIsDeleted(that.getIsDeleted());
		setFacilityFee(that.getFacilityFee());
		setTransportFee(that.getTransportFee());
		setTransitionFee(that.getTransitionFee());
		setMovingFee(that.getMovingFee());
		setAwardFee(that.getAwardFee());
		setDiscontinuedFee(that.getDiscontinuedFee());
		setSelfdemolitionFee(that.getSelfdemolitionFee());
		setOtherFee(that.getOtherFee());
		setTotal(that.getTotal());
		setPerFee(that.getPerFee());
		setLastComputeTime(that.getLastComputeTime());
		setActualBackHouseArea(that.getActualBackHouseArea());
		setActualBackBusinessArea(that.getActualBackBusinessArea());
		setCuser(that.getCuser());
		setProject(that.getProject());
		setRecordTransitionfees(new java.util.LinkedHashSet<common.domain.RecordTransitionfee>(that.getRecordTransitionfees()));
	}

	

	

	

	@Override
	public String toString() {
		return "Record [id=" + id + ", projectName=" + projectName
				+ ", firstStartTime=" + firstStartTime + ", firstEndTime="
				+ firstEndTime + ", username=" + username + ", usercontact="
				+ usercontact + ", useraddress=" + useraddress
				+ ", useridcard=" + useridcard + ", contractNumber="
				+ contractNumber + ", recordNumber=" + recordNumber
				+ ", coveredArea=" + coveredArea + ", coveredAreaBack="
				+ coveredAreaBack + ", houseArea=" + houseArea
				+ ", houseAreaBack=" + houseAreaBack + ", houseAreaBackReturn="
				+ houseAreaBackReturn + ", houseAreaBackRoom="
				+ houseAreaBackRoom + ", businessArea=" + businessArea
				+ ", businessAreaBack=" + businessAreaBack
				+ ", businessAreaBackReturn=" + businessAreaBackReturn
				+ ", businessAreaBackRoom=" + businessAreaBackRoom
				+ ", productionArea=" + productionArea
				+ ", productionAreaBack=" + productionAreaBack
				+ ", productionAreaBackReturn=" + productionAreaBackReturn
				+ ", productionAreaBackRoom=" + productionAreaBackRoom
				+ ", actualBackHouseArea=" + actualBackHouseArea
				+ ", actualBackBusinessArea=" + actualBackBusinessArea
				+ ", overArea=" + overArea + ", overAreaBusiness="
				+ overAreaBusiness + ", otherArea=" + otherArea
				+ ", pendingState=" + pendingState + ", replaceFlag="
				+ replaceFlag + ", replaceBusinessAreaBefore="
				+ replaceBusinessAreaBefore + ", replaceHouseAreaBefore="
				+ replaceHouseAreaBefore + ", replaceBusinessArea="
				+ replaceBusinessArea + ", replaceHouseArea="
				+ replaceHouseArea + ", replaceAreaTotal=" + replaceAreaTotal
				+ ", replaceBusinessRatio=" + replaceBusinessRatio
				+ ", replaceHouseRatio=" + replaceHouseRatio + ", balance1="
				+ balance1 + ", balance2=" + balance2 + ", balanceDeal="
				+ balanceDeal + ", bankAccount=" + bankAccount
				+ ", selfRemoveArea=" + selfRemoveArea + ", selfSimplyArea="
				+ selfSimplyArea + ", selfRemoveAmount=" + selfRemoveAmount
				+ ", startDealTime=" + startDealTime + ", lastDealTime="
				+ lastDealTime + ", isDealed=" + isDealed + ", remark="
				+ remark + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", isStart=" + isStart + ", isEnd=" + isEnd
				+ ", createdTime=" + createdTime + ", lastEditTime="
				+ lastEditTime + ", deletedTime=" + deletedTime
				+ ", isDeleted=" + isDeleted + ", areaBenefit100="
				+ areaBenefit100 + ", facilityFee=" + facilityFee
				+ ", transportFee=" + transportFee + ", transitionFee="
				+ transitionFee + ", movingFee=" + movingFee + ", awardFee="
				+ awardFee + ", discontinuedFee=" + discontinuedFee
				+ ", selfdemolitionFee=" + selfdemolitionFee + ", otherFee="
				+ otherFee + ", total=" + total + ", channel=" + channel
				+ ", oldProjectNo=" + oldProjectNo + ", infoId=" + infoId
				+ ", planReturnHouseInfo=" + planReturnHouseInfo
				+ ", planReturnBusinessInfo=" + planReturnBusinessInfo
				+ ", perFee=" + perFee + ", lastComputeTime=" + lastComputeTime
				+ ", cuser=" + cuser + ", project=" + project
				+ ", recordTransitionfees=" + recordTransitionfees + "]";
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Record))
			return false;
		Record equalCheck = (Record) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
