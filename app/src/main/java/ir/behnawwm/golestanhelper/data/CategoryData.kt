package ir.behnawwm.golestanhelper.data

import ir.behnawwm.golestanhelper.views.main.fragments.category.categoryDetails.CategoryDetailsListItem
import ir.behnawwm.golestanhelper.views.main.fragments.category.categoryDetails.ResultItem

object CategoryData {

    fun provideDaneshjooyiItems() =
        listOf(
            CategoryDetailsListItem(
                "خوابگاه", null, listOf(
                    ResultItem("اطلاعات جامع خوابگاه دانشجو", 19700, false),
                    ResultItem("اطلاعات خوابگاهی دانشجو", 19280, false),
                    ResultItem("درخواست خوابگاه", 19290, false),
                    ResultItem("درخواست گروهی خوابگاه", 19340, false),
                    ResultItem("پرداخت های الکترونیکی بابت خوابگاه", 19050, false),
                    ResultItem("درخواست میزبانی مهمان خوابگاه توسط دانشجو", 21450, false),
                    ResultItem("درخواست مهمانی در خوابگاه توسط دانشجو جاری", 29640, false),
                    ResultItem("پرداخت های الکترونیکی مهمان بابت خوابگاه", 13070, false),
                    ResultItem("پرداخت هزینه مهمان توسط میزبان", 29260, false),
                    ResultItem("اعتراض دانشجو به حضور مهمان خوابگاه", 29230, false),
                    ResultItem("اعلام عدم حضور دانشجو/مهمان در خوابگاه", 16150, false),
                    )
            ),
            CategoryDetailsListItem(
                "وام دانشجویی", null, listOf(
                    ResultItem("وضعیت وام های درخواست شده توسط دانشجوییان", 969, true)
                )
            ),
            CategoryDetailsListItem(
                "کار دانشجویی", null, listOf(
                    ResultItem("ثبت درخواست کار توسط دانشجو", 19910, false),
                    ResultItem("اطلاعات جامع کار دانشجو - دوره ای", 29740, false)
                )
            ),
        )

    fun provideMaliItems() =
        listOf(
            CategoryDetailsListItem(
                "تسویه حساب دانشجویان", null, listOf(
                    ResultItem("مشاهده موارد تسویه حساب جهت ابطال کارت", 12230, false),
                    ResultItem("تسویه حساب های موردنیاز هر دانشجو", 522, true)
                )
            )
        )

    fun provideSabtenamItems() =
        listOf(
            CategoryDetailsListItem(
                "ثبت نام مقدماتی", null, listOf(
                    ResultItem("لیست دروس ارائه شده در ثبت نام مقدماتی", 51, true),
                    ResultItem("دروس پیشنهادی به دانشجو در ثبت نام مقدماتی", 75, true),
                    ResultItem("نتیجه ثبت نام مقدماتی دانشجو", 76, true)
                )
            ),
            CategoryDetailsListItem(
                "ثبت نام", null, listOf(
                    ResultItem(
                        "لیست اولویت دانشجویان جهت ثبت نام، ترمیم، پذیرش، مراجعه به درمانگاه و درخواست گروهی خوابگاه",
                        59,
                        true
                    ),
                    ResultItem("ثبت نام دانشجو با توجه به تغییرات جدید دروس", 74, true),
                    ResultItem("نتیجه ثبت نام (ترمیم) دانشجو در طول ثبت نام", 77, true),
                    ResultItem("برنامه هفتگی دانشجو در طول ثبت نام", 88, true),
                    ResultItem("گروه های درسی تکمیل نشده", 112, true),
                    ResultItem("گروه های درسی در شرف تکمیل", 113, true),
                )
            )
        )

    fun provideArzeshyabiItems() =
        listOf(
            CategoryDetailsListItem(
                "استاد", null, listOf(
                    ResultItem("ارزشیابی استاد", 13860, false),
                )
            ),
            CategoryDetailsListItem(
                "نظرسنجی", null, listOf(
                    ResultItem("پاسخگویی افراد به سوال های نظرسنجی", 15160, false),
                )
            )
        )

    fun provideSystemItems() =
        listOf(
            CategoryDetailsListItem(
                "کاربران", null, listOf(
                    ResultItem("تغییر گذرواژه", 11160, false),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                )
            ),
        )

    fun providePishkhanItems() =
        listOf(
            CategoryDetailsListItem(
                "پیشخوان خدمت", null, listOf(
                    ResultItem("پیشخوان خدمت", 21120, false),
                )
            )
        )

    fun provideAmoozeshItems() =
        listOf(
            CategoryDetailsListItem(
                "دانشجو", null, listOf(
                    ResultItem("تغییر گذرواژه", 11160, false),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                    ResultItem("گذرواژه دانشجویان در سیستم های دیگر", 672, true),
                )
            ),
            CategoryDetailsListItem(
                "جلسه درس، امتحان و نمره", null, listOf(
                    ResultItem("غیبت های دانشجو", 1950, true),
                )
            ),
            CategoryDetailsListItem(
                "شهریه", null, listOf(
                    ResultItem("پرداخت های الکترونیکی دانشجو", 15450, false),
                )
            ),
            CategoryDetailsListItem(
                "نامه های اداری", null, listOf(
                    ResultItem("لیست نامه های دانشجو", 84, true),
                    ResultItem("معرفی نامه درخواست کارآموزی", 1115, true),
                    ResultItem("معرفی نامه قطعی کارآموزش", 1116, true),
                    ResultItem(
                        "معرفی نامه کارآموزی دانشجویان ثبت نام شده در سامانه پذیرش و جایابی وزارت علوم",
                        1170,
                        true
                    ),
                )
            ),
            CategoryDetailsListItem(
                "اطلاعات جامع دانشجو", null, listOf(
                    ResultItem("اطلاعات جامع دانشجو", 12310, false),
                )
            ),
            CategoryDetailsListItem(
                "گزارش های آموزش", listOf(
                    CategoryDetailsListItem(
                        "دانشجو", null, listOf(
                            ResultItem("مدارک تحویل شده/تحویل نشده هر دانشجو", 221, true),
                            ResultItem("تصویر نسخه الکترونیکی مدارک دانشجو", 1700, true),
                            ResultItem("نتیجه ثبت نام دانشجو", 423, true),
                            ResultItem("نتیجه ثبت نام دانشجو (شهریه)", 403, true),
                            ResultItem("برنامه هفتگی دانشجو", 78, true),
                            ResultItem("برنامه امتحان پایان ترم دانشجو", 428, true),
                            ResultItem(
                                "تطبیق دروس دانشجو برای فارغ التحصیلان(یدون نمره)",
                                284,
                                true
                            ),
                            ResultItem("کارنامه کلی-غیررسمی دانشجو", 1000, true),
                            ResultItem("کارنامه ترمی دانشجو", 79, true),
                            ResultItem("ریزنمرات دانشجو", 572, true),
                        )
                    ),
                    CategoryDetailsListItem(
                        "درس", null, listOf(
                            ResultItem("لیست نظام های مجاز یا غیرمجاز به اخذ درس", 430, true),
                            ResultItem("پیش نیاز، همزمان، متضاد و معادل دروس", 107, true),
                            ResultItem("معدل و واحد گذرانده لازم جهت اخذ دروس", 568, true),
                            ResultItem("معدل و واحد گذرانده جهت اخذ دروس هر مقطع", 569, true),
                            ResultItem("درس در پیش نیاز، هم نیاز و متضاد سایر دروس", 108, true),
                        )
                    ),
                    CategoryDetailsListItem(
                        "درس های ترمی", null, listOf(
                            ResultItem("دروس ارائه شده در ترم و شرایط اخذ انها", 102, true),
                            ResultItem("دروس ارائه شده در ترم", 110, true),
                            ResultItem("گزارش دروس ارائه شده (ویژه دانشجو)", 211, true),
                            ResultItem("لیست دروس ازائه شده (ویژه دانشجو)", 212, true),
                            ResultItem("لیست شرایط اخذ گروه درس", 474, true),
                        )
                    ),
                    CategoryDetailsListItem(
                        "شورا", null, listOf(
                            ResultItem("لیست آرا شورا", 173, true),
                        )
                    ),
                    CategoryDetailsListItem(
                        "امتحان", null, listOf(
                            ResultItem("برنامه امتحانات دروس", 206, true),
                        )
                    ),
                ), null
            )
        )
}