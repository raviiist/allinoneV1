package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Set;

public class Controller {
    @FXML
    private Hyperlink testSceneLink;

    @FXML
    private Button b2;

    @FXML
    private Button b1;

    @FXML
    private Button b3;

    @FXML
    private Button b21;

    @FXML
    private Button b11;

    @FXML
    private Button b31;

    @FXML
    private Button b211;

    @FXML
    private Button b111;

    @FXML
    private Button b311;

    @FXML
    private Button b2111;

    @FXML
    private Button b1111;

    @FXML
    private Button b3111;

    @FXML
    private Button b212;

    @FXML
    private Button b112;

    @FXML
    private Button b312;

    @FXML
    private Button b3121;

    @FXML
    private Button b31211;

    @FXML
    private Button b21111;

    @FXML
    private Button b11111;

    @FXML
    private Button b31111;

    @FXML
    private Button b21112;

    @FXML
    private Button b11112;

    @FXML
    private Button b31112;

    @FXML
    private Button b211111;

    @FXML
    private Button b111111;

    @FXML
    private Button b211121;

    @FXML
    private Button b111121;

    @FXML
    private Button b311121;
    String configArea="/home/ravi/Documents/allinone/";
    String configFile="config.inp";
    Path congFilePath= Paths.get(configArea+configFile);

    String str=loadConfigData(congFilePath);
    String dconf[]=str.split(" ");
    int noofdata= dconf.length;       //noofdata=5 is fixed here
    String noofexec= dconf[noofdata-1];
 //   int noe= Integer.parseInt(noofexec);

    String sat= dconf[0];
    String hm= dconf[1];
    String enD=".exec";
    String fbrowser=dconf[2],payload=dconf[3],niorb=dconf[4],dailyplt=dconf[5],dailyrpt=dconf[6],acecmd=dconf[7],sharp=dconf[8],
            nrt=dconf[9],aceexe=dconf[10],sps=dconf[11],gts=dconf[12],obtevents=dconf[13],popverify=dconf[14],popdetail=dconf[15],
            popblk=dconf[16],arcchk=dconf[17],printsch=dconf[18],ssrdetail=dconf[19],obcdrft=dconf[20],dftsl=dconf[21],
            dftns=dconf[22],obcdftlog=dconf[23],omcmd=dconf[24],drccmd=dconf[25],omlog=dconf[26],drclog=dconf[27],
            cmdlog=dconf[28],phone=dconf[29],satsch=dconf[30];

    //private Stage primaryStage;

    void exeMaker(String exefile) {
        Charset charset = Charset.forName("US-ASCII");
        String exeline4terminal = "gnome-terminal --geometry=100x25 -- sh -c \""+hm+"/"+exefile+"; exec sh\"";
        String str1 = hm+"/"+exefile+"_"+sat+enD;
        Path fpath = Paths.get(str1);
        BufferedWriter writer = null;
        try {
            if(!Files.exists(fpath)) {
            writer = Files.newBufferedWriter(fpath, charset);
            //writer = Files.newBufferedWriter(file, charset);

                writer.write(String.format(exeline4terminal + "%n%n"), 0, exeline4terminal.length() + 2);
                Set<PosixFilePermission> perms = Files.readAttributes(fpath, PosixFileAttributes.class).permissions();
                //System.out.println("Permission before:" + PosixFilePermissions.toString(perms));
                perms.add(PosixFilePermission.OWNER_EXECUTE);
                perms.add(PosixFilePermission.GROUP_EXECUTE);
                perms.add(PosixFilePermission.OTHERS_EXECUTE);
                Files.setPosixFilePermissions(fpath, perms);
                //System.out.println("Permission now:" + PosixFilePermissions.toString(perms));
            }
        } catch (IOException xxe) {
            System.err.format("IOException: %s%n", xxe);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String loadConfigData(Path file) {
        String line = null, satids="xxx", homedir="",noofexe="";
        String FBROWSER="",PAYLOAD="",NIORB="",DAILYPLT="",DAILYRPT="",ACECMD="",SHARP="",NRT="",ACEEXE="",SPS="",GTS="",
                OBTEVENTS="",POPVERIFY="",POPDETAIL="",POPBLK="",ARCCHK="",PRINTSCH="",SSRDETAIL="",OBCDRFT="",DFTSL="",
                DFTNS="",OBCDFTLOG="",OMCMD="",DRCCMD="",OMLOG="",DRCLOG="",CMDLOG="",PHONE="",SATSCH="";
        String sp[];
        try {
            BufferedReader br = Files.newBufferedReader(file);
            while ((line = br.readLine()) != null) {
                if(line.length() == 3) {
                    satids=line.substring(0,3);
                System.out.println(satids);
                //return satids;
                }
                if(line.contains("HOME") && (line.length()) > 5) {
                    homedir=line.substring(5);
                    System.out.println(homedir);
                }
                if(line.contains("FBROWSER") && (line.length()) > 9) {
                    sp=line.split(" ");
                    FBROWSER=sp[0].substring(9);
                    System.out.println(FBROWSER);
                }
                if(line.contains("PAYLOAD") && (line.length()) > 8) {
                    sp=line.split(" ");
                    PAYLOAD=sp[0].substring(8);
                    System.out.println(PAYLOAD+" "+PAYLOAD.length());
                }
                if(line.contains("NIORB") && (line.length()) > 6) {
                    sp=line.split(" ");
                    NIORB=sp[0].substring(6);
                    System.out.println(NIORB);
                }
                if(line.contains("DAILYPLT") && (line.length()) > 9) {
                    sp=line.split(" ");
                    DAILYPLT=sp[0].substring(9);
                    System.out.println(DAILYPLT);
                }
                if(line.contains("DAILYRPT") && (line.length()) > 9) {
                    sp=line.split(" ");
                    DAILYRPT=sp[0].substring(9);
                    System.out.println(DAILYRPT);
                }
                if(line.contains("ACECMD") && (line.length()) > 7) {
                    sp=line.split(" ");
                    ACECMD=sp[0].substring(7);
                    System.out.println(ACECMD);
                }
                if(line.contains("SHARP") && (line.length()) > 6) {
                    sp=line.split(" ");
                    SHARP=sp[0].substring(6);
                    System.out.println(SHARP);
                }
                if(line.contains("NRT") && (line.length()) > 4) {
                    sp=line.split(" ");
                    NRT=sp[0].substring(4);
                    System.out.println(NRT);
                }
                if(line.contains("ACEEXE") && (line.length()) > 7) {
                    sp=line.split(" ");
                    ACEEXE=sp[0].substring(7);
                    System.out.println(ACEEXE);
                }
                if(line.contains("SPS") && (line.length()) > 4) {
                    sp=line.split(" ");
                    SPS=sp[0].substring(4);
                    System.out.println(SPS);
                }
                if(line.contains("GTS") && (line.length()) > 4) {
                    sp=line.split(" ");
                    GTS=sp[0].substring(4);
                    System.out.println(GTS);
                }
                if(line.contains("OBTEVENTS") && (line.length()) > 10) {
                    sp=line.split(" ");
                    OBTEVENTS=sp[0].substring(10);
                    System.out.println(OBTEVENTS);
                }
                if(line.contains("POPVERIFY") && (line.length()) > 10) {
                    sp=line.split(" ");
                    POPVERIFY=sp[0].substring(10);
                    System.out.println(POPVERIFY);
                }
                if(line.contains("POPDETAIL") && (line.length()) > 10) {
                    sp=line.split(" ");
                    POPDETAIL=sp[0].substring(10);
                    System.out.println(POPDETAIL);
                }
                if(line.contains("POPBLK") && (line.length()) > 7) {
                    sp=line.split(" ");
                    POPBLK=sp[0].substring(7);
                    System.out.println(POPBLK);
                }
                if(line.contains("ARCCHK") && (line.length()) > 7) {
                    sp=line.split(" ");
                    ARCCHK=sp[0].substring(7);
                    System.out.println(ARCCHK);
                }
                if(line.contains("PRINTSCH") && (line.length()) > 9) {
                    sp=line.split(" ");
                    PRINTSCH=sp[0].substring(9);
                    System.out.println(PRINTSCH);
                }
                if(line.contains("SSRDETAIL") && (line.length()) > 10) {
                    sp=line.split(" ");
                    SSRDETAIL=sp[0].substring(10);
                    System.out.println(SSRDETAIL);
                }
                if(line.contains("OBCDRFT") && (line.length()) > 8) {
                    sp=line.split(" ");
                    OBCDRFT=sp[0].substring(8);
                    System.out.println(OBCDRFT);
                }
                 if(line.contains("DFTSL") && (line.length()) > 6) {
                    sp=line.split(" ");
                    DFTSL=sp[0].substring(6);
                    System.out.println(DFTSL);
                }
                if(line.contains("DFTNS") && (line.length()) > 6) {
                    sp=line.split(" ");
                    DFTNS=sp[0].substring(6);
                    System.out.println(DFTNS);
                }
                if(line.contains("OBCDFTLOG") && (line.length()) > 10) {
                    sp=line.split(" ");
                    OBCDFTLOG=sp[0].substring(10);
                    System.out.println(OBCDFTLOG);
                }
                if(line.contains("OMCMD") && (line.length()) > 6) {
                    sp=line.split(" ");
                    OMCMD=sp[0].substring(6);
                    System.out.println(OMCMD);
                }
                if(line.contains("DRCCMD") && (line.length()) > 7) {
                    sp=line.split(" ");
                    DRCCMD=sp[0].substring(7);
                    System.out.println(DRCCMD);
                }
                if(line.contains("OMLOG") && (line.length()) > 6) {
                    sp=line.split(" ");
                    OMLOG=sp[0].substring(6);
                    System.out.println(OMLOG);
                }
                if(line.contains("DRCLOG") && (line.length()) > 7) {
                    sp=line.split(" ");
                    DRCLOG=sp[0].substring(7);
                    System.out.println(DRCLOG);
                }
                if(line.contains("CMDLOG") && (line.length()) > 7) {
                    sp=line.split(" ");
                    CMDLOG=sp[0].substring(7);
                    System.out.println(CMDLOG);
                }
                if(line.contains("PHONE") && (line.length()) > 6) {
                    sp=line.split(" ");
                    PHONE=sp[0].substring(6);
                    System.out.println(PHONE);
                }
                if(line.contains("SATSCH") && (line.length()) > 7) {
                    sp=line.split(" ");
                    SATSCH=sp[0].substring(7);
                    System.out.println(SATSCH);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return satids+" "+homedir+" "+FBROWSER+" "+PAYLOAD+" "+NIORB+" "+DAILYPLT+" "+DAILYRPT+" "+ACECMD+" "+SHARP+" "+NRT+
                " "+ACEEXE+" "+SPS+" "+GTS+" "+OBTEVENTS+" "+POPVERIFY+" "+POPDETAIL+" "+POPBLK+" "+ARCCHK+" "+PRINTSCH+
                " "+SSRDETAIL+" "+OBCDRFT+" "+DFTSL+" "+DFTNS+" "+OBCDFTLOG+" "+OMCMD+" "+DRCCMD+" "+OMLOG+" "+DRCLOG+
                " "+CMDLOG+" "+PHONE+" "+SATSCH+" "+noofexe;
    }

    //String stid=st.charAt(0)+""+st.charAt(1)+""+st.charAt(2);

/*    @FXML
    void checkMouseMove(MouseEvent event) {
    //String st=loadConfigData(congFilePath);
        System.out.println("Hello "+st);            "+stid+"    cmd1="$HOME/dss_rs2QT"
    }*/

    String cmd1=hm+"/"+aceexe+"_"+sat+enD, cmd2=hm+"/"+dailyplt+"_"+sat+enD, cmd3=hm+"/"+dailyrpt+"_"+sat+enD, cmd4=hm+"/"+sharp+"_"+sat+enD;
    String cmd5=hm+"/"+nrt+"_"+sat+enD, cmd6=hm+"/"+sps+"_"+sat+enD, cmd7=hm+"/"+gts+"_"+sat+enD, cmd8=hm+"/"+obtevents+"_"+sat+enD;
    String cmd9=hm+"/"+payload+"_"+sat+enD, cmd10=hm+"/"+popdetail+"_"+sat+enD, cmd11=hm+"/"+popblk+"_"+sat+enD, cmd12=hm+"/"+niorb+"_"+sat+enD;
    String cmd13=hm+"/"+acecmd+"_"+sat+enD, cmd14=hm+"/"+arcchk+"_"+sat+enD, cmd15=hm+"/"+printsch+"_"+sat+enD, cmd16=hm+"/"+popverify+"_"+sat+enD;
    String cmd17=hm+"/"+ssrdetail+"_"+sat+enD, cmd18=hm+"/"+obcdrft+"_"+sat+enD, cmd19=hm+"/"+dftsl+"_"+sat+enD, cmd20=hm+"/"+dftns+"_"+sat+enD;
    String cmd21=hm+"/"+obcdftlog+"_"+sat+enD, cmd22=hm+"/"+omlog+"_"+sat+enD, cmd23=hm+"/"+drclog+"_"+sat+enD, cmd24=hm+"/"+omcmd+"_"+sat+enD;
    String cmd25=hm+"/"+drccmd+"_"+sat+enD, cmd26=hm+"/"+cmdlog+"_"+sat+enD, cmd27=hm+"/"+phone+"_"+sat+enD, cmd28=hm+"/"+satsch+"_"+sat+enD;
    @FXML
    void aissum(ActionEvent event) {
        exeMaker(nrt);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd5);
        try {
            Process p = Runtime.getRuntime().exec(cmd5);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void aocelog(ActionEvent event) {
        exeMaker(obcdftlog);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd21);
        try {
            Process p = Runtime.getRuntime().exec(cmd21);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void arcCheck(ActionEvent event) {
        exeMaker(arcchk);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd14);
        try {
            Process p = Runtime.getRuntime().exec(cmd14);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chkG2B(ActionEvent event) {
        exeMaker(acecmd);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd13);
        try {
            Process p = Runtime.getRuntime().exec(cmd13);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chkpbalive(ActionEvent event) {
        exeMaker(popverify);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd16);
        try {
            Process p = Runtime.getRuntime().exec(cmd16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cmdlog(ActionEvent event) {
        exeMaker(cmdlog);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd26);
        try {
            Process p = Runtime.getRuntime().exec(cmd26);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void drclog(ActionEvent event) {
        exeMaker(drccmd);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd25);
        try {
            Process p = Runtime.getRuntime().exec(cmd25);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void driftNS(ActionEvent event) {
        exeMaker(dftns);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd20);
        try {
            Process p = Runtime.getRuntime().exec(cmd20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void driftSL(ActionEvent event) {
        exeMaker(dftsl);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd19);
        try {
            Process p = Runtime.getRuntime().exec(cmd19);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void genais(ActionEvent event) {
        exeMaker(sharp);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd4);
        try {
            Process p = Runtime.getRuntime().exec(cmd4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gendss(ActionEvent event) {
        exeMaker(aceexe);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd1);
        try {
            Process p = Runtime.getRuntime().exec(cmd1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void genniorb(ActionEvent event) {
        exeMaker(niorb);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd12);
        try {
            Process p = Runtime.getRuntime().exec(cmd12);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void genplot(ActionEvent event) {
        exeMaker(dailyplt);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd2);
        try {
            Process p = Runtime.getRuntime().exec(cmd2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void genpop(ActionEvent event) {
        exeMaker(payload);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd9);
        try {
            Process p = Runtime.getRuntime().exec(cmd9);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void genreport(ActionEvent event) {
        exeMaker(dailyrpt);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd3);
        try {
            Process p = Runtime.getRuntime().exec(cmd3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gensps0(ActionEvent event) {
        exeMaker(sps);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd6);
        try {
            Process p = Runtime.getRuntime().exec(cmd6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void omlog(ActionEvent event) {
        exeMaker(omcmd);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd24);
        try {
            Process p = Runtime.getRuntime().exec(cmd24);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orbperlog(ActionEvent event) {
        exeMaker(drclog);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd23);
        try {
            Process p = Runtime.getRuntime().exec(cmd23);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void phonebook(ActionEvent event) {
        exeMaker(phone);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd27);
        try {
            Process p = Runtime.getRuntime().exec(cmd27);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void popblk(ActionEvent event) {
        exeMaker(popblk);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd11);
        try {
            Process p = Runtime.getRuntime().exec(cmd11);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void popdetails(ActionEvent event) {
        exeMaker(popdetail);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd10);
        try {
            Process p = Runtime.getRuntime().exec(cmd10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void rs2cntdwn(ActionEvent event) {
        exeMaker(satsch);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd28);
        try {
            Process p = Runtime.getRuntime().exec(cmd28);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void rs2events(ActionEvent event) {
        exeMaker(obtevents);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd8);
        try {
            Process p = Runtime.getRuntime().exec(cmd8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sadalog(ActionEvent event) {
        exeMaker(omlog);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd22);
        try {
            Process p = Runtime.getRuntime().exec(cmd22);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void schprint(ActionEvent event) {
        exeMaker(printsch);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd15);
        try {
            Process p = Runtime.getRuntime().exec(cmd15);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showdrift(ActionEvent event) {
        exeMaker(obcdrft);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd18);
        try {
            Process p = Runtime.getRuntime().exec(cmd18);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showgts(ActionEvent event) {
        exeMaker(gts);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd7);
        try {
            Process p = Runtime.getRuntime().exec(cmd7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ssrdetails(ActionEvent event) {
        exeMaker(ssrdetail);
        System.out.println(sat+" "+hm+" dataEntry:"+noofdata+" madeByJavaEXE:"+cmd17);
        try {
            Process p = Runtime.getRuntime().exec(cmd17);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Time t = new Time();
        Time t2 = new Time();
        // 3 milliseconds it takes to change the time/execute a line
        t2.changeTimeByDelta(5000);
        System.out.println(t.toString()+", changed is:"+t2.toString());
        long l1 = t.getTimeInMillis();
        SimpleDateFormat sdfI6 = new SimpleDateFormat("yyyy DDD HH-mm-ss.SSS");
        SimpleDateFormat sdfCal = new SimpleDateFormat("yyyy MM dd HH mm ss SSS");
        SimpleDateFormat sdfCal1 = new SimpleDateFormat("yyyy MMM dd HH mm ss SSS");
        SimpleDateFormat sdfCal2 = new SimpleDateFormat("EEE, MMM/MMMMM d,yyyy hh mm ss SSS: a, z:Z, yyMMddHHmmssZ:XXX");
        System.out.println(t.toString()+", "+t.getString(sdfI6)+", "+t.getString(sdfCal2)+":"+l1);
        String s0=t.toString()+", "+t.getString(sdfI6)+", "+t.getString(sdfCal2)+":"+l1;
        //String[] ar1={t.toString(),", ",t.getString(sdfI6),", ",t.getString(sdfCal2),":",l1}
        System.out.println("-------------------");
        //Splits into strings with defined regex And converts strings into array
        String[] ar1=s0.split(" ");
        // trim() -->it has no leading or trailing white space.
        System.out.println(ar1.length+"::"+ar1[ar1.length-1]+"::"+s0.trim()+"::");
        System.out.println("-------------------");
        // "\s+" this takes care of multiple whitespaces with 10 split size/blocks of 10 objects/ array size of 10
        String[] ar2=s0.trim().split("\\s+",10);
        // converts Arrays to string.
        System.out.println((ar2+"::"+ar2.length+"::"+ Arrays.toString(ar2).replaceAll("]","").replaceAll("\\[","").replaceAll(", "," ")));
        System.out.println(ar2+"::"+ar2.length+"::"+s0);
        System.out.println("-------------------");
        String s1="2018 288 15-39-11.864";
        Time t3 = new Time(s1,sdfI6);
        System.out.println(t3.getTimeInMillis() +" "+t.getTimeInMillis());
        /*try {
            System.out.println(sdfCal.parse(s1));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }


    @FXML
    public void showPOP(ActionEvent event) {
        System.out.println("This source has been uploaded to github.");
        String command1="netstat";
        //String command2="diskmgmt.msc";
        String command2="/home/ravi/f1";
        try {
            //-------------------------------------------
            //Process process = Runtime.getRuntime().exec("diskmgmt.msc");
            //-------------------------------------------
            /*ProcessBuilder pb=new ProcessBuilder("diskmgmt.msc");
            pb.redirectErrorStream(true);
            Process process=pb.start();
            BufferedReader inStreamReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));*/
            //-------------------------------------------
            /*Process process = Runtime.getRuntime().exec(command1);
            System.out.println("the output stream is "+process.getOutputStream());
            BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null){
                System.out.println("The inout stream is " + s);
            }*/                                                                    //WORKS but
            //-------------------------------------------
            //Process p = Runtime.getRuntime().exec("cmd /c diskmgmt.msc");     //WORKS PERFECTLY
            /*Process p = Runtime.getRuntime().exec("cmd /c "+command1);  //WORKS but
            String s;                                                           //
            System.out.println(p.getOutputStream());                            //
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));                     //
            while((s=stdInput.readLine())!=null){                               //
                System.out.println(s);                                          //

            }                                 */                                  //WORKS but
            //-------------------------------------------
            Process p = Runtime.getRuntime().exec(command2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void chaneSceneNow(ActionEvent event) throws IOException {

        Parent parentScene2 = FXMLLoader.load(getClass().getResource("testScene.fxml"));
        Scene scene2 = new Scene(parentScene2);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }


}
