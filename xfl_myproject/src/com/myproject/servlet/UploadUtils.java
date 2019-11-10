package com.myproject.servlet;

public class UploadUtils {
	
	public static String getRealName(String path) {
	    int index = path.lastIndexOf("\\");
	 
	    if (index == -1) {
	      index = path.lastIndexOf("/");
	    }
	 
	    return path.substring(index + 1);
	  }
	 
	  /**
	   * @param name
	   * 
	   * @return 路径判断
	   */
	  public static String getDir(String name) {
	    int i = name.hashCode();
	    String hex = Integer.toHexString(i);
	    int j = hex.length();
	 
	    for (int k = 0; k < 8 - j; k++) {
	      hex = "0" + hex;
	    }
	 
	    return "/" + hex.charAt(0) + "/" + hex.charAt(1);
	  }
	


}
