package com.bm.world.dep;

/**
 * This class used for declare the all constants
 */
public class ApplicationConstants {
	private ApplicationConstants() {}
    //TABLE Name Constants
    public static final  String DEPARTMENT_DETAILS_TABLE="departments_details";
    //Controller claass Constatns
    public static final String BASE_URL="/bm/dept";
    public static final String SAVE_DEPT="/savedept";
    public static final String DELETE_DEPT="/del/{departmentId}";
    public static final String UPDATE_DEPT="/update";
    public static final String GET_ALL_DEPT="/getAllDepts";
    public static final String GET__DEPT_BY_ID="/{departmentId}";
    // messages constants
    public static final String DEPT_SAVE_MESSAGE="save department with this id:\t";
    public static final String DEPT_DELETE_MESSAGE="deleted department with this id:\t";
    public static final String DEPT_UPDATE_MESSAAGE="updated depertment with this id:\t";

}
