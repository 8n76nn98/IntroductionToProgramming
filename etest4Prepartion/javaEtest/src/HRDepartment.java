import java.util.*;

public class HRDepartment implements HRCodes {
    ArrayList<Employee>employeeList;
    public HRDepartment()
    {
        employeeList =new ArrayList<>();
    }
    public void addEmployee(int employeeId,String name,int role)
    {
        Employee temp = new Employee(employeeId,name,role);
        employeeList.add(temp);
    }
    public Employee findEmployee(int employeeId)
    {
        boolean found = false;

        for(int index = 0;index<employeeList.size()&&(!found);index++)
        {
            int currentId = employeeList.get(index).getEmployeeId();
            if(currentId==employeeId)
            {
                found = true;
                Employee temp = employeeList.get(index);
                return temp;
            }
        }
        return null;
    }
    public void printAllEmployees()
    {
        for(int index = 0 ;index<employeeList.size();index++)
        {
            System.out.println(employeeList.get(index).toString());
        }
    }
    public int differentDayMillsecond(Date date1,Date date2)
    {
        //second one minus first one
        int differenceDay = (int)(date2.getTime()-date1.getTime())/(3600*1000*24);
        return differenceDay;
    }
    public boolean promoteEmployee(int employeeId)
    {
        Employee currentEmployee = null;
        boolean successful = false;
        boolean finished = false;
        for(int index = 0;index<employeeList.size()&&(!finished);index++)
        {
            int tempId = employeeList.get(index).getEmployeeId();
            if(tempId==employeeId)
            {
                finished=true;
                currentEmployee =employeeList.get(index);
            }
        }
        if(currentEmployee!=null)
        {
            if(currentEmployee.getRole()!=EXECUTIVE)
            {
                ArrayList<EmployeeAppraisal>currentEmployeeAppraisalHistory= currentEmployee.getAppraisalHistory();

                int lastScore =0;

                int  size = currentEmployeeAppraisalHistory.size();
                if(size !=0)
                {
                    Object tempScore1 =currentEmployeeAppraisalHistory.get(currentEmployeeAppraisalHistory.size()-1);
                    if(tempScore1==null)
                    {
                        lastScore= DID_NOT_MEET_EXPECTATIONS;
                    }
                    else
                    {
                       // Collections.sort(currentEmployeeAppraisalHistory);
                        lastScore= currentEmployeeAppraisalHistory.get(currentEmployeeAppraisalHistory.size()-1).getAppraisalScore();

                    }
                    int sizeOfApprialHistory = currentEmployeeAppraisalHistory.size();
                    int lastTwoScore =0;
                    if(size<2)
                    {
                        lastTwoScore=DID_NOT_MEET_EXPECTATIONS;

                    }
                    else
                    {
                       // Collections.sort(currentEmployeeAppraisalHistory);
                        lastTwoScore=currentEmployeeAppraisalHistory.get(currentEmployeeAppraisalHistory.size()-2).getAppraisalScore();

                    }
                    // int lastTwoScore = currentEmployeeAppraisalHistory.get(currentEmployeeAppraisalHistory.size()-2).getAppraisalScore();
                    if((lastScore ==	EXCEEDED_EXPECTATIONS)&&(lastTwoScore==EXCEEDED_EXPECTATIONS))
                    {
                        //last promotion date;
                        boolean stop = false;
                        EmployeeAppraisal employeeAppraisalTemp=null;
                        int currentIndex = 0;
                        int previousIndex = 0;

                        for(int i = currentEmployeeAppraisalHistory.size()-1 ; i>=0&&(!stop);i--)
                        {
                            boolean temp =currentEmployeeAppraisalHistory.get(i).getPromoted();

                            if(temp==false)
                            {
                                currentEmployeeAppraisalHistory.get(i).setPromoted(true);
                                currentIndex=i;

                                employeeAppraisalTemp=currentEmployeeAppraisalHistory.get(i);
                                stop=true;
                            }
                        }
                        Date lastTimeOfEmployeePromoationDate =employeeAppraisalTemp.getAppraisalDate();
                        employeeAppraisalTemp.setPromoted(true);

                        //getting the date from the promotion at least one year ago
                        for(int i = currentEmployeeAppraisalHistory.size()-1;i>=0;i--)
                        {
                            boolean temp =currentEmployeeAppraisalHistory.get(i).getPromoted();
                            if(temp==false)
                            {
                                previousIndex=i;
                            }

                        }
                        Date previousDateNotPromotion = currentEmployeeAppraisalHistory.get(previousIndex).getAppraisalDate();
                        Date recentPromotionDate = employeeAppraisalTemp.getAppraisalDate();
                        int differenceDay = differentDayMillsecond(previousDateNotPromotion,recentPromotionDate);
                        if(differenceDay>=365 )
                        {
                            int currentEmployeeRole = currentEmployee.getRole();
                            switch (currentEmployeeRole)
                            {
                                case TESTER:
                                    currentEmployeeRole=DEVELOPER;
                                    break;
                                case DEVELOPER:
                                    currentEmployeeRole=DESIGNER;
                                    break;
                                case DESIGNER:
                                    currentEmployeeRole=MANAGER;
                                    break;
                                case MANAGER:
                                    currentEmployeeRole=EXECUTIVE;
                                    break;
                            }
                           // currentEmployee.getAppraisalHistory().get(currentEmployeeAppraisalHistory.size()-1).setAppraisalDate(currentTime);
                            successful=true;
                            return successful;

                        }
                    }
                }

            }



        }
        return successful;

    }
    public boolean recordEmployeeAppraisal(int employeeId, Date appraisalDate, int score)
    {
        Employee currentEmployee =findEmployee(employeeId);
        boolean found =false;
        EmployeeAppraisal tempAppraisal=null;
        if(currentEmployee!=null)
        {
          //  tempAppraisal = new EmployeeAppraisal(appraisalDate,score);
            ArrayList<EmployeeAppraisal>currentEmployeeAppraisalHistory = currentEmployee.getAppraisalHistory();

            currentEmployeeAppraisalHistory.add(new EmployeeAppraisal(appraisalDate,score));
            currentEmployee.setAppraisalHistory(currentEmployeeAppraisalHistory);
            found=true;
        }
        return found;
    }
}
