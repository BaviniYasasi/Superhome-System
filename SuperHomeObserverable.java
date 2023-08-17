public class SuperHomeObserverable {
    private HomeObserver[] dataArray=new HomeObserver[100];
    private int nextIndex=0;
    private int superHome;
    private int listIndex;
    private String startHour,startMinute,endHour,endMinute;
    public void setHomeObserver(HomeObserver observer) {
        dataArray[nextIndex++] = observer;
    }
    public void setSuperHome(int superHome){
        if (this.superHome!=superHome){
            this.superHome=superHome;
            notifyObservers();
        }
    }
    public void setIndex(int index){
        if(this.listIndex!=listIndex){
           this.listIndex=listIndex;
        }

    }
    public void setTime(String startHour,String startMinute,String endHour,String endMinute){
        if (this.startHour !=startHour||this.startMinute!=startMinute || this.endHour!=endHour || this.endMinute!=endMinute){
            this.startHour=startHour;
            this.startMinute=startMinute;
            this.endHour=endHour;
            this.endMinute=endMinute;
            notifyIndex();
        }
    }
    public void notifyIndex(){
        dataArray[listIndex].setTime(startHour,startMinute,endHour,endMinute);

    }
    public void notifyObservers(){
        for (int i = 0; i < nextIndex; i++) {
            dataArray[i].update(superHome);
        }
    }

}
