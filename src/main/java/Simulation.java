import javax.security.auth.login.AccountExpiredException;
import javax.sql.rowset.FilteredRowSet;
import java.sql.SQLOutput;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static int line = 8;
    public int link = 3;
    public static int Usedlink =0;
    public static int clock = 0;
    public static int processed=0;
    public static int completed=0;
    public static int block=0;
    public static int busy=0;
    public static List<ArrivalEvents> arrivallist = new ArrayList<>();
    public static List<CallInProcess> callList = new ArrayList<>();


    public void arrivalEventManager(){
        int From =(int)(Math.random()*line+1); //Math.floor(Math.random()*(max-min+1)+min)
        int to =(int) Math.floor(Math.random()*(line-1+1)+1);
           if(From == to){
                while(From == to ){
                    to = (int) Math.floor(Math.random()*(line-1+1)+1);
                }
           }
        int arrivalTime= (int) Math.floor(Math.random()*(50-clock+clock)+clock);
        int lenght = (int) Math.floor(Math.random()*(10-1+1)+1);

        arrivallist.add(new ArrivalEvents(From,to,lenght,arrivalTime));
    }

    public boolean checkerBlockbsuy( ArrivalEvents a){
        for(CallInProcess c : callList){
            if(a.getFrom() == c.getFrom() || a.getTo() == c.getTo()){
                busy++;
                return true;
                //break;
            }else if (Usedlink>link){
                block++;
                return true;
               // break;
            }
        }
        return false;
    }

    public void ArrivalEventChecker(){
        List<ArrivalEvents> deletelist = new ArrayList<>();
           for(ArrivalEvents a : arrivallist){
               if(a.getArrivalTime() == clock){
                   processed++;
                   int end = a.length+clock;
                     if (callList.isEmpty()){
                          callList.add(new CallInProcess(a.getFrom(),a.getTo(),end));
                          Usedlink++;
                     }else {
                          if(checkerBlockbsuy(a)==false){
                              callList.add(new CallInProcess(a.getFrom(),a.getTo(),end));
                              Usedlink++;
                          }

                     }
                   deletelist.add(a);
               }
           }
           arrivallist.removeAll(deletelist);
    }


   public void CallListChecker(){
        List<CallInProcess> deletecall = new ArrayList<>();
        for(CallInProcess c : callList){
            if (c.getEnd() == clock){
                deletecall.add(c);
                Usedlink--;
                completed++;
            }
        }
        callList.removeAll(deletecall);
   }



    public static void main(String[] args) {
        Simulation s = new Simulation();
        while (true){
            s.clock++;
             s.arrivalEventManager();
             s.ArrivalEventChecker();
             s.CallListChecker();
//             for(ArrivalEvents a: arrivallist){
//                 System.out.println("From:"+a.getFrom());
//                 System.out.println("To:"+a.getTo());
//                 System.out.println("Length:"+a.getLength());
//                 System.out.println("Arrival Time:"+a.getArrivalTime());
//
//             }
//        for(CallInProcess c: callList){
//            System.out.println("call list");
//            System.out.println("From:"+c.getFrom());
//            System.out.println("To:"+c.getTo());
//            System.out.println("End:"+c.getEnd());

     //   }
            System.out.println("=============================================================================");
            System.out.println("block:"+s.block);
            System.out.println("Busy: "+s.busy);
            System.out.println("Processed: "+s.processed);
            System.out.println("UsesLink: "+s.Usedlink);
            System.out.println("Completed:"+s.completed);
            System.out.println("================================================================================");

            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }

            if(s.clock==100){
                break;
            }
         }


    }
}
