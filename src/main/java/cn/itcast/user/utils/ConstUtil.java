package cn.itcast.user.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量工具 
 * [0-1]系统，00:标签引擎,01:标签体系
 * [2-3]系统模块【标签引擎】,00:全局,01:模型管理,02:计算管理,03:知识管理,04:待办事项,05:辅助工具
 * [2-3]系统模块【标签体系】,00:全局,01:标签,02:审核状态
 * [4-5]具体业务字典
 * [5-6]具体字典码
 * 两位字典码逢10进1
 */
public interface ConstUtil {
	
	public final static String ISNULL = "not allowed to be empty";
	
	public final static String ENNAMEREGEX = "([A-Z]|[a-z]|[0-9]|_){0,}";
	
	public final static String SIGNREGEX = "^[a-zA-Z0-9\\u4E00-\\u9FA5]+$";
	
	/**仅仅支持字母*/
	public final static String ZIMU = "[a-zA-Z]+";
	
	
	
	
	
	//[00]
	//**********************全局Start********************
	
	/**
	 * 权限定义
	 * [02]
	 */
	enum PERMISSIONDEFINITION{
		/**创建/修改对象分类*/
		P_CORUOBJECTGROUP("000201","创建/修改对象分类");
		
		//2018-建-04-04
		
		
		public final String ID;
        public final String NAME;
        private PERMISSIONDEFINITION(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static PERMISSIONDEFINITION get(String id){
			for(PERMISSIONDEFINITION s:PERMISSIONDEFINITION.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	
	/**
	 * 接口响应字典
	 * [01]
	 */
	enum RESPONSE{
		/**响应成功*/
		_SUCSSESS("000101","响应成功"),
		/**未登录,响应失败*/
		_NOTLOGGEDIN("000102","token校验失败,检查登录"),
		/**内部服务异常*/
		_SERVICEERROR("000103","内部服务异常"),
		/**逻辑异常/参数异常/非空/存在/不合法*/
		_LOGICERROR("000104","检查请求体是否遵循接口规范");
		
		
		public final String ID;
        public final String NAME;
        private RESPONSE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static RESPONSE get(String id){
			for(RESPONSE s:RESPONSE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	//**********************全局End********************
	
	
	//[01]
	//**********************对象Start********************
	/**
	 * 模型类别字典
	 * [01]
	 */
	enum OBJTYPE{
		/**数据模型*/
		_DATAOBJECT("010101","数据模型"),
		/**目标模型*/
		_TARGETOBJECT("010102","目标模型");
		
		public final String ID;
        public final String NAME;
        private OBJTYPE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static OBJTYPE get(String id){
			for(OBJTYPE s:OBJTYPE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	
	//**********************对象End********************
	
	//[03]
	//**********************知识库Start********************
	/**
	 * 知识库类型 [01]
	 */
	enum KNOWLEDGETYPE {
		/** 枚举 */
		_ENUM("030101", "枚举"),
		/** 列表 */
		_TAB("030102", "列表");

		public final String ID;
		public final String NAME;

		private KNOWLEDGETYPE(String id, String nm) {
			ID = id;
			NAME = nm;
		}

		public String getID() {
			return ID;
		}

		public String getNAME() {
			return NAME;
		}

		public static KNOWLEDGETYPE get(String id) {
			for (KNOWLEDGETYPE s : KNOWLEDGETYPE.values()) {
				if (s.ID.equals(id)) {
					return s;
				}
			}
			return null;
		}
	}
	
	
	/**
	 * 枚举字典类型 [02]
	 */
	enum KTYPE {
		/** 目录 */
		_ML("030201", "目录"),
		/** 公用字典 */
		_GYZD("030202", "公用字典"),
		/** 标签字典私有 */
		_BQZD("030203", "标签私有字典");

		public final String ID;
		public final String NAME;

		private KTYPE(String id, String nm) {
			ID = id;
			NAME = nm;
		}

		public String getID() {
			return ID;
		}

		public String getNAME() {
			return NAME;
		}

		public static KTYPE get(String id) {
			for (KTYPE s : KTYPE.values()) {
				if (s.ID.equals(id)) {
					return s;
				}
			}
			return null;
		}
	}
		
	//**********************知识库End********************
	
	
	//**********************标签计算START********************
	
	
	/**SQL任务策略*/
	enum STRATEG {
		/** 每月 */
		_MONTHLY("020201", "每月"),
		/** 每周 */
		_WEEKLY("020202", "每周"),
		/** 每天*/
		_DAILY("020203","每天"),
		/** 每小时*/
		_HOURLY("020204","每小时"),
		/** 一次性*/
		_DISPOSABLE("020205","一次性");

		public final String ID;
		public final String NAME;

		private STRATEG(String id, String nm) {
			ID = id;
			NAME = nm;
		}

		public String getID() {
			return ID;
		}

		public String getNAME() {
			return NAME;
		}

		public static STRATEG get(String id) {
			for (STRATEG s : STRATEG.values()) {
				if (s.ID.equals(id)) {
					return s;
				}
			}
			return null;
		}
	}
	
	//**********************标签计算END********************
	
	//模型
	
	enum SYSTEMCODE {
		/**标签系统*/
		_LABEL("010201", "标签引擎"),
		/**数据资源导航系统 */
		_SJZYDH("010202", "数据资源导航"),
		/**泛目标*/
		_FMB("010203", "泛目标"),
		/**标签体系*/
		_LABELSYS("010204", "标签体系");

		public final String ID;
		public final String NAME;

		private SYSTEMCODE(String id, String nm) {
			ID = id;
			NAME = nm;
		}

		public String getID() {
			return ID;
		}

		public String getNAME() {
			return NAME;
		}

		public static SYSTEMCODE get(String id) {
			for (SYSTEMCODE s : SYSTEMCODE.values()) {
				if (s.ID.equals(id)) {
					return s;
				}
			}
			return null;
		}
	}
	
	//模型end
	
	//0101[标签体系]start***********************************8
	
	/**
	 * 【标签体系】标签类别字典
	 * [010101]
	 */
	enum LABELTYPE{
		/**分类*/
		_FL("01010101","分类"),
		/**维度*/
		_WD("01010102","维度"),
		/**标签*/
		_BQ("01010103","标签"),
		//后补
		/**聚合标签*/
		_JHBQ("01010105","聚合标签");
		public final String ID;
        public final String NAME;
        private LABELTYPE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static LABELTYPE get(String id){
			for(LABELTYPE s:LABELTYPE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	/**标签状态*/
	enum LABELSTATUS{
		/**正常*/
		_ZC("01010301","正常"),
		/**老化，下线*/
		_LH("01010302","老化、下线"),
		/**删除*/
		_SC("01010303","删除"),
		/**注册审核中*/
		_ZCSH("01010304","注册审核中"),
		/**注册审核未通过*/
		_ZCSHWTG("01010305","注册审核未通过");
		public final String ID;
        public final String NAME;
        private LABELSTATUS(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static LABELSTATUS get(String id){
			for(LABELSTATUS s:LABELSTATUS.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	
	/**
	 * 【标签体系】标签权限字典
	 * [010102]
	 */
	enum LABELJURISDICTION{
		/**可见可用*/
		_KJKY("01010201","可见可用"),
		/**可见不可用*/
		_KJBKY("01010202","可见不可用"),
		/**不可见不可用*/
		_BKJBKY("01010203","不可见不可用"),
		/**自定义*/
		_ZDY("01010204","自定义");
		
		public final String ID;
        public final String NAME;
        private LABELJURISDICTION(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static LABELJURISDICTION get(String id){
			for(LABELJURISDICTION s:LABELJURISDICTION.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	/**
	 * 【标签体系】体系字典
	 * [010104]
	 */
	enum SYSCODE{
		/**标签体系*/
		_BQTX("01010401","标签体系"),
		/**数据体系*/
		_SJTX("01010402","数据体系"),
		/**知识体系*/
		_ZSTX("01010403","知识体系"),
		/**目标体系*/
		_MBTX("01010404","目标体系");
		
		public final String ID;
        public final String NAME;
        private SYSCODE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static SYSCODE get(String id){
			for(SYSCODE s:SYSCODE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
		
		public static List<String> getSystemCodeList(){
			List<String> list = new ArrayList<>();
			list.add("01010401");
			list.add("01010402");
			list.add("01010403");
			list.add("01010404");
			list.add("");
			return list;
		}
	}
	
	
	
	/**
	 * 【标签体系】共享状态字典
	 * [010105]
	 */
	enum SHARESTATUS{
		/**正常*/
		_ZC("01010501","正常状态"),
		/**撤回*/
		_CH("01010502","撤回共享");
		public final String ID;
        public final String NAME;
        private SHARESTATUS(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static SHARESTATUS get(String id){
			for(SHARESTATUS s:SHARESTATUS.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	/**
	 * 【标签体系】共享状态审核状态字典
	 * [010105]
	 */
	enum SHAREAPPROVALSTATUS{
		/**共享申请*/
		_GXSQ("01010701","共享申请"),
		/**共享申请_同意*/
		_QXSQTY("01010702","共享申请同意"),
		/**共享申请_被拒绝*/
		_QXSQBJJ("01010703","共享申请被拒绝"),
		/**同步申请*/
		_TBSQ("01010704","同步申请"),
		/**同步申请_同意*/
		_TBSQTY("01010705","同步申请同意"),
		/**同步申请_被拒绝*/
		_TBSQPJJ("01010706","同步被拒绝");
		public final String ID;
        public final String NAME;
        private SHAREAPPROVALSTATUS(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static SHAREAPPROVALSTATUS get(String id){
			for(SHAREAPPROVALSTATUS s:SHAREAPPROVALSTATUS.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	
	/**
	 * 【标签体系】
	 * [010106]
	 */
	enum TREE_GETOPYION{
		/**使用*/
		_USE("01010602","使用标签"),
		/**预览*/
		_VIEW("01010601","预览标签");
		public final String ID;
        public final String NAME;
        private TREE_GETOPYION(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static TREE_GETOPYION get(String id){
			for(TREE_GETOPYION s:TREE_GETOPYION.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	
	//[标签体系]end***********************************8
	
	//0102[标签体系-审核start]*************************************
	/**
	 * 【标签体系】审核状态字典
	 * [010201]
	 */
	enum LABELAPPROVALSTATUS{
		/**已提交审核*/
		_YTJSH("01020101","已提交审核"),
		/**审核通过*/
		_SHTG("01020102","审核通过"),
		/**审核驳回*/
		_SHBH("01020103","审核驳回");
		
		public final String ID;
        public final String NAME;
        private LABELAPPROVALSTATUS(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static LABELAPPROVALSTATUS get(String id){
			for(LABELAPPROVALSTATUS s:LABELAPPROVALSTATUS.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	/**
	 * 【标签体系】审核类型
	 * [010202]
	 */
	enum LABELAPPROVALTYPE{
		/**标签注册审核*/
		_BQZCSH("01020201","标签注册审核"),
		/**标签编辑审核*/
		_BQBJSH("01020202","标签编辑审核"),
		/**标签删除审核*/
		_BQSCSH("01020203","标签删除审核"),
		/**标签聚合审核*/
		_BQJHSH("01020204","标签聚合审核");
		//TODO 继续添加
		
		public final String ID;
        public final String NAME;
        private LABELAPPROVALTYPE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static LABELAPPROVALTYPE get(String id){
			for(LABELAPPROVALTYPE s:LABELAPPROVALTYPE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	//[标签体系-审核end]*************************************
	
	
	
	//**************中台部分开始***************************
	
	enum SYSTEMRESPONSECODE{
		/**操作失败,系统异常*/
		_XTYC("000101","操作失败，系统异常"),
		_LJYC("000102","操作失败，逻辑异常"),
		_CZCG("000103","操作成功。");
		//TODO 继续添加
		
		public final String ID;
        public final String NAME;
        private SYSTEMRESPONSECODE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static SYSTEMRESPONSECODE get(String id){
			for(SYSTEMRESPONSECODE s:SYSTEMRESPONSECODE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	
	enum DICTCODE{
		_SYSTEMCODE("SYSTEMCODE","系统编码");
		//TODO 继续添加
		
		public final String ID;
        public final String NAME;
        private DICTCODE(String id, String nm) {
            ID = id;
            NAME = nm;
        }
		public String getID() {
			return ID;
		}
		public String getNAME() {
			return NAME;
		}
		public static DICTCODE get(String id){
			for(DICTCODE s:DICTCODE.values()){
				if(s.ID.equals(id)){
					return s;
				}
			}
			return null;
		}
	}
	

}
