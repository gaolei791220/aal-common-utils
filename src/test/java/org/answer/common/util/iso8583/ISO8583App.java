package org.answer.common.util.iso8583;

import com.alibaba.fastjson.JSON;
import org.answer.common.util.iso8583.AIISO8583DTO;
import org.answer.common.util.iso8583.TransISO8583MessageUtil;

/**
 * Created by Answer.AI.L on 2019-03-07 10:15
 */
public class ISO8583App {

    public static void main(String[] args) throws Exception {
        final String TPDU = "6000000000";
        final String HEAD = "612200000000";
        String recvMsg = "00BA600000000061220000000003007020048000C1805B193104890100000006059063000000000000010000018298009130383030303030332020202020202020202030303038303030303030303030303100040000313536005553560118FFFFFFFFFFFF03104890100000006059FFFFFFFF0101000200000064020000080000032017122310225672FB47880000012B01001141000006000000120000060001810016303030303030303030303030303030304435373336384239";
        AIISO8583DTO aiISO8583DTO = (AIISO8583DTO) TransISO8583MessageUtil.unpackISO8583(AIISO8583DTO.class, recvMsg);
        System.out.println("UNPACK ISO8583: \n" + JSON.toJSONString(aiISO8583DTO));

        System.out.println();

        String maxBitmap = "7020048000C1805B";
        String sendMsg = TransISO8583MessageUtil.packISO8583(aiISO8583DTO, maxBitmap, TPDU, HEAD, "0300");
        System.out.println("PACK ISO8583: \n" + sendMsg);
    }

}