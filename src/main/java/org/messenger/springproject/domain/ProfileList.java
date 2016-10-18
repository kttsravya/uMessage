package org.messenger.springproject.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ProfileList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private List<Profile> pList;
	public ProfileList(){
		
	}
	public List<Profile> getPList(){
		return pList;
	}
	public void setProfileList(List<Profile> newprofileList){
		this.pList = newprofileList;
	}
	public int numEntries(){
		if(pList==null){
			return 0;
		}
		return pList.size();
	}
	public Profile getProfile(int idx){
		return pList.get(idx);
	}
	
	public String toString() {
	String listStr;
	
	listStr = "ProfileList{";
	for (Profile entry: pList) {
		listStr = listStr + "\n\t" + entry;
	}
	
	listStr = listStr + "\n}";
	return listStr;
}
}







