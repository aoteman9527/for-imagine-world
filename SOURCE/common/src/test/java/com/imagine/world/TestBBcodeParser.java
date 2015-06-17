package com.imagine.world;

import junit.framework.TestCase;
import org.jjcode.Node;
import org.jjcode.Parser;
import org.jjcode.RenderEngine;
import org.jjcode.sample.SampleUsage;

import java.util.Locale;

/**
 * Created by letuan on 5/4/14.
 */
public class TestBBcodeParser extends TestCase{
    public void testGettingStarted(){
        String bodyData = "[COLOR=#ff0000][SIZE=22px]Người truyền ký ức (Tái bản)[/SIZE][/COLOR] [SIZE=22px]Tác giả: Lois Lowry [/SIZE] [SIZE=22px][COLOR=#ffd700]44800[/COLOR][/SIZE] [COLOR=#008000]Cho dù một ai đã từng đọc những lời giới thiệu ngắn gọn xung quanh cuốn sách, không đọc cũng không thể nào cảm nhận hết sự kỳ lạ của nó. [B]Người truyền ký ức tuyệt vời ở trí tưởng tưởng và những thông điệp mang theo.[/B][/COLOR] [COLOR=#008000]Một cộng đồng không được xác định rõ về không gian và thời gian tồn tại, chỉ biết những thành phần của nó có hình hài giống như con người, và một vài cấu trúc cũng giống như con người. Đứng đầu cộng đồng có một Hội đồng quyết định tất thảy mọi việc, dĩ nhiên, vẫn còn một thế lực cao siêu nào đó hơn nữa, chỉ huy về tổng thể. Mỗi cá nhân sinh ra không bởi cha mẹ họ, mà bởi những Mẹ đẻ, những người phụ nữ được nhận Nhiệm vụ sinh nở ra bé mới cho cộng đồng.[/COLOR] [IMG]http://www.atlazbooks.com/images/book/image/nguoi_truyen_ky_uc_tai_ban_.jpg[/IMG]";
        SampleUsage.setUp();
        String filtered = SampleUsage.engine.render(bodyData, RenderEngine.MODE_RENDER, Locale.US);
        System.out.println(filtered);

        Parser p = new Parser();
        Node root = p.parse(bodyData.toString());

    }



}
