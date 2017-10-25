package test;

import com.kh.admin.common.utils.JAXBUtil;
import com.kh.admin.model.flightBus.Row;
import com.kh.admin.model.flightBus.root;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;



/**
 * 所在的包名: test
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 14:54 2017/6/9
 */
public class flightBusTest {

    @Test
    public void test(){

        String xml = "<root>\n" +
                "<header><srcserver>1001</srcserver><needtrans /><tagserver>DC</tagserver><service>TKNodeQuery</service><transid /></header>\n" +
                "<parameters><OpStation>779</OpStation><DstNode /></parameters>\n" +
                "    <data>\n" +
                "        <row NDStation=\"\" NDCode=\"0003\" NDShortcut=\"SHDS\" NDName=\"深航大厦\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:52:45\" NDNotes=\"\" NDNamePY=\"SHDX\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0004\" NDShortcut=\"TZDS\" NDName=\"投资大厦\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:54:08\" NDNotes=\"\" NDNamePY=\"TZDX\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0005\" NDShortcut=\"HLDS\" NDName=\"华联大厦\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:54:51\" NDNotes=\"\" NDNamePY=\"HLDX\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0006\" NDShortcut=\"DYDTZ\" NDName=\"大运地铁站\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:56:26\" NDNotes=\"\" NDNamePY=\"DYDTZ\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0007\" NDShortcut=\"ALDTZ\" NDName=\"爱联地铁站\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:57:07\" NDNotes=\"\" NDNamePY=\"ALDTZ\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0008\" NDShortcut=\"LGCSHJL\" NDName=\"龙岗城市候机楼\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:57:46\" NDNotes=\"\" NDNamePY=\"LGCSHJL\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0009\" NDShortcut=\"LSDTZ\" NDName=\"龙胜地铁站\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:58:52\" NDNotes=\"\" NDNamePY=\"LSDTZ\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0010\" NDShortcut=\"JDMLZ\" NDName=\"金地梅陇镇\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 15:59:37\" NDNotes=\"\" NDNamePY=\"JDMLZ\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0011\" NDShortcut=\"NXGC\" NDName=\"南贤广场\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 16:00:45\" NDNotes=\"\" NDNamePY=\"NXGC\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0012\" NDShortcut=\"SZBZ\" NDName=\"深圳北站\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 16:01:11\" NDNotes=\"\" NDNamePY=\"SZBZ\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0013\" NDShortcut=\"SZNS\" NDName=\"南山车站\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2016-03-30 21:57:45\" NDNotes=\"\" NDNamePY=\"NSCZ\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0001\" NDShortcut=\"SZJC\" NDName=\"深圳机场\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-10 19:58:01\" NDNotes=\"\" NDNamePY=\"SZJC\" Sort=\"9999\"/>\n" +
                "        <row NDStation=\"\" NDCode=\"0002\" NDShortcut=\"LHHCZ\" NDName=\"罗湖火车站\" NDEName=\"\" NDProvince=\"广东省\" NDCity=\"深圳市\" NDDistrict=\"\" NDOpTime=\"2015-11-24 16:02:54\" NDNotes=\"\" NDNamePY=\"LHHCZ\" Sort=\"9999\"/>\n" +
                "    </data>\n" +
                "    <response>\n" +
                "        <errcode>0</errcode>\n" +
                "        <errmsg></errmsg>\n" +
                "    </response>\n" +
                "</root>";
        root xmlToJson = JAXBUtil.converyToJavaBean(xml, root.class);
        String errcode = xmlToJson.getResponse().getErrcode();
        System.out.println(errcode);
        List<Row> row = xmlToJson.getRow();
        for(Row rowLists : row){
            System.out.println(rowLists);
        }
    }


    @Test
    public void webServiceTest(){


    }

}
