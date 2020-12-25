package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        textView=findViewById(R.id.introduce);
        textView.setText("西南财经大学天府学院是将西南财经大学三大校区之一的涪江校区整体置换而设立的独立学院。学院完全继承了原西南财经大学电子商务学院的全部校园建筑、师资队伍、管理队伍、教学仪器设备、图书资料、学生生活设施以及整体办学理念。\n" +
                "\n" +
                "西南财经大学天府学院图书馆成立于2002年，现由绵阳校区大图书馆、三教阅览室、成都龙潭校区东区图书馆、成都龙潭校区西区图书馆以及各楼栋书吧五部分组成，各校区图书馆均有独立馆藏。\n" +
                "\n" +
                "经过近14年的建设，西南财经大学天府学院图书馆已藏书200多万册，形成了以经济、管理、计算机、英语类图书为主，涵盖所有专业门类的馆藏体系，能满足现有本科30个专业、专科24个专业、艺术4个专业以及国际双文凭实验班2万多名师生的学习、科研和阅读需求。除此之外，现有纸质期刊1000余种，纸质报纸100余种，同时还拥有中国知网CNKI资源、超星数字图书馆、维普考试资源系统、电子书阅读机等众多电子资源，形成了纸质资源与数字资源并存、实际拥有资源和远程可利用资源并举的综合性文献资源服务体系。\n" +
                "\n" +
                "图书馆已全面实现计算机集成化管理，开通了流通、采访、编目、典藏、检索、期刊、办公等子系统。学院局域网内的用户可以在网上实现馆藏图书、新书目录的查阅以及是否超期、图书续借、本人借阅资料的查询等功能，同时开通了多渠道咨询服务。\n" +
                "\n" +
                "图书馆秉承学院“一个头脑，两个工具”的办学理念，切实贯彻学院“小社会、大课堂”的教育方针，努力为学生提供各种实践锻炼的机会，致力于为师生提供共享、开架、实时、优质和快捷的创新服务。\n" +
                "\n" +
                "图书馆充分体现\"以人为本\"的服务理念，每周开馆时间长达101小时，图书外借开放时间每周50小时；节假日、寒暑假照常开放，电子文献提供24小时在线服务。\n" +
                "\n" +
                "作为绵阳市文献信息资源共建共享服务示范馆，我馆长期致力于信息资源的共享和社会化服务。在资源共享方面，运用我们的资源优势与绵阳市图书馆进行共建共享，推进公共文化服务体系的建设；在社会化服务方面，校外读者可免费入馆阅读，并可办理图书借阅证进行借还书。\n" +
                "\n" +
                "\n");
    }

    @Override
    protected void onPause() {
        Intent intent=new Intent(Introduction.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}