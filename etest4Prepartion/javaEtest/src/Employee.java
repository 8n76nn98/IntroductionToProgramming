import java.util.*;
/*
 class Mycomparator implements Comparator {
	public int compare(Object o1, Object o2) {
		EmployeeAppraisal p1 = (EmployeeAppraisal) o1;
		EmployeeAppraisal p2 = (EmployeeAppraisal) o2;
		if (p1.getDayValue() < p2.getDayValue()) {
			return 1;
		} else {
			return -1;
		}
	}
}

 */
public class Employee {
	private final int employeeId;
	private String name;
	private Date promotionDate;
	private int role;
	private ArrayList<EmployeeAppraisal> appraisalHistory;
	HashMap<Integer,EmployeeAppraisal>map;
	ArrayList<Integer>sortArrayList;
	//private PriorityQueue<EmployeeAppraisal>pq;


	
	public Employee(int employeeId, String name, int role) {
		this.employeeId = employeeId;
		this.name = name;
		this.promotionDate = null;
		this.role = role;
		this.appraisalHistory = new ArrayList<EmployeeAppraisal>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPromotionDate() {
		return promotionDate;
	}
	public void setPromotionDate(Date promotionDate) {
		this.promotionDate = promotionDate;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public void sortDate()
	{
		Collections.sort(this.appraisalHistory, new Comparator<EmployeeAppraisal>() {
			@Override
			public int compare(EmployeeAppraisal o1, EmployeeAppraisal o2) {
				return new Integer(o1.getDayValue()).compareTo(o2.getDayValue());
			}
		});

	}
	public ArrayList<EmployeeAppraisal> getAppraisalHistory() {
		int SIZE = this.appraisalHistory.size();
		if(SIZE>=2)
		{
			sortDate();
			/*
			HashMap<Integer,EmployeeAppraisal>map=null;
			ArrayList<Integer>sortArrayList=null;
			sortArrayList = new ArrayList<Integer>();
			map = new 	HashMap<Integer,EmployeeAppraisal>();
			for(EmployeeAppraisal temp :this.appraisalHistory)
			{
				int x = temp.getDayValue();
				sortArrayList.add(x);
				map.put(x,temp);
			}
			Collections.sort(sortArrayList);
			appraisalHistory.clear();
			for(int i = 0 ;i <sortArrayList.size();i++)
			{
				int dayTempValue = sortArrayList.get(i);
				if(map.containsKey(dayTempValue))
				{
					EmployeeAppraisal tempAppreial = map.get(dayTempValue);
					appraisalHistory.add(tempAppreial);
				}
			}

			//Mycomparator comp = new Mycomparator();
			//Collections.sort(appraisalHistory,comp);

			 */


		}


		return this.appraisalHistory;
	}
	public void setAppraisalHistory(ArrayList<EmployeeAppraisal> appraisalHistory) {
		this.appraisalHistory = appraisalHistory;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	@Override
	public String toString() {
		String output = "";
		output+="----------------------------------------------------\n";
		output+="Employee [employeeId=" + employeeId + ", name=" + name + ", promotionDate="
				+ promotionDate + ", role=" + role +"\n";
		output+="This employee's appraisalHistory is as following list"+"\n";
		if(this.appraisalHistory.size()==0)
		{
			output+="This employees's appraisalhistory is empty \n";
		}
		else
		{
			sortDate();

			for(int index = 0;index<this.appraisalHistory.size();index++)
			{
				EmployeeAppraisal temp = this.appraisalHistory.get(index);
				output += "No."+(index+1)+ "appraisal is :" ;
				output +=temp.toString();
				output+="\n";
				if(temp.getPromoted()==true)
				{
					output+="This date has   been promoted  ";
					output+="\n";

				}
				else
				{
					output+="This date has not  been promoted  ";
					output+="\n";
				}

				output+="\n";
			}
		}
		output+="-----------------------------------------------------------";

		output+="\n";
		return output;
	}
	
	
	
}
