package com.aor.refactoring.example6;

import java.util.Calendar;
import java.util.Date;

public class AppraisalDate implements Comparable<AppraisalDate> {
    private final Date date;

    public AppraisalDate(Date date){
        this.date = date;
    }

    public AppraisalDate(){
        this(new Date());
    }

    public Date getDate() {
        return date;
    }

    public AppraisalDate nextAppraisalDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getDate());
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        return new AppraisalDate(calendar.getTime());
    }

    public boolean isInThePast(){
        return getDate().before(new Date());
    }

    @Override
    public int compareTo(AppraisalDate appraisalDate) {
        return this.date.compareTo(appraisalDate.getDate());
    }
}
