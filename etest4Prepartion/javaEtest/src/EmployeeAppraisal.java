import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

public class EmployeeAppraisal  {
	private Date appraisalDate;
	private int appraisalScore;
	private boolean Promoted;
	private int dayValue;

	
	private int DateToValue(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		String dateString = format.format(date);
		String []arryDate = dateString.toString().split("-");
		int day = Integer.parseInt(arryDate[0]);
		int month = Integer.parseInt(arryDate[1]);
		int year = Integer.parseInt(arryDate[2]);
		this.dayValue = year*10000;
		this.dayValue+=month*100;
		this.dayValue+=day;
		return this.dayValue;
	}

	public boolean getPromoted() {
		return this.Promoted;
	}


	public int getDayValue()
	{
		return this.dayValue;
	}

	public EmployeeAppraisal(Date appraisalDate, int appraisalScore) {
		this.appraisalDate = appraisalDate;
		this.appraisalScore = appraisalScore;
		this.Promoted = false;
		this.dayValue =DateToValue(this.appraisalDate);
		
	}

	public void setPromoted(boolean promoted) {
		this.Promoted = promoted;
	}

	public Date getAppraisalDate() {
		return appraisalDate;
	}
	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}
	public int getAppraisalScore() {
		return appraisalScore;
	}
	public void setAppraisalScore(int appraisalScore) {
		this.appraisalScore = appraisalScore;
	}
	
	@Override
	public String toString() {
		return "EmployeeAppraisal [appraisalDate=" + appraisalDate + ", appraisalScore=" + appraisalScore + "]";
	}




}
