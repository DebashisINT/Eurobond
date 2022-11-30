package com.eurobond.app

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import android.content.Context

import com.eurobond.app.AppConstant.DBNAME
import com.eurobond.app.domain.*
import com.eurobond.features.lead.model.LeadActivityDao
import com.eurobond.features.lead.model.LeadActivityEntity
import com.eurobond.features.location.UserLocationDataDao
import com.eurobond.features.location.UserLocationDataEntity
import com.eurobond.features.login.*


/*
 * Copyright (C) 2017 Naresh Gowd Idiga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Database(entities = arrayOf(AddShopDBModelEntity::class, UserLocationDataEntity::class, UserLoginDataEntity::class, ShopActivityEntity::class,
    StateListEntity::class, CityListEntity::class, MarketingDetailEntity::class, MarketingDetailImageEntity::class, MarketingCategoryMasterEntity::class,
    TaListDBModelEntity::class, AssignToPPEntity::class, AssignToDDEntity::class, WorkTypeEntity::class, OrderListEntity::class,
    OrderDetailsListEntity::class, ShopVisitImageModelEntity::class, UpdateStockEntity::class, PerformanceEntity::class,
    GpsStatusEntity::class, CollectionDetailsEntity::class, InaccurateLocationDataEntity::class, LeaveTypeEntity::class, RouteEntity::class,
    ProductListEntity::class, OrderProductListEntity::class, StockListEntity::class, RouteShopListEntity::class, SelectedWorkTypeEntity::class,
    SelectedRouteEntity::class, SelectedRouteShopListEntity::class, OutstandingListEntity::class/*, LocationEntity::class*/,
    IdleLocEntity::class, BillingEntity::class, StockDetailsListEntity::class, StockProductListEntity::class, BillingProductListEntity::class,
    MeetingEntity::class, MeetingTypeEntity::class, ProductRateEntity::class, AreaListEntity::class, PjpListEntity::class,
    ShopTypeEntity::class, ModelEntity::class, PrimaryAppEntity::class, SecondaryAppEntity::class, LeadTypeEntity::class,
    StageEntity::class, FunnelStageEntity::class, BSListEntity::class, QuotationEntity::class, TypeListEntity::class,
    MemberEntity::class, MemberShopEntity::class, TeamAreaEntity::class, TimesheetListEntity::class, ClientListEntity::class,
    ProjectListEntity::class, ActivityListEntity::class, TimesheetProductListEntity::class, ShopVisitAudioEntity::class,
    TaskEntity::class, BatteryNetStatusEntity::class, ActivityDropDownEntity::class, TypeEntity::class,
    PriorityListEntity::class, ActivityEntity::class, AddDoctorProductListEntity::class, AddDoctorEntity::class,
    AddChemistProductListEntity::class, AddChemistEntity::class, DocumentypeEntity::class, DocumentListEntity::class, PaymentModeEntity::class,
    EntityTypeEntity::class, PartyStatusEntity::class, RetailerEntity::class, DealerEntity::class, BeatEntity::class, AssignToShopEntity::class,
    VisitRemarksEntity::class,ShopVisitCompetetorModelEntity::class,
    OrderStatusRemarksModelEntity::class,CurrentStockEntryModelEntity::class,CurrentStockEntryProductModelEntity::class,
    CcompetetorStockEntryModelEntity::class,CompetetorStockEntryProductModelEntity::class,
    ShopTypeStockViewStatus::class,
    NewOrderGenderEntity::class,NewOrderProductEntity::class,NewOrderColorEntity::class,NewOrderSizeEntity::class,NewOrderScrOrderEntity::class,ProspectEntity::class,
    QuestionEntity::class,QuestionSubmitEntity::class,AddShopSecondaryImgEntity::class,ReturnDetailsEntity::class
    ,ReturnProductListEntity::class,UserWiseLeaveListEntity::class,ShopFeedbackEntity::class,ShopFeedbackTempEntity::class,LeadActivityEntity::class,
    ShopDtlsTeamEntity::class,CollDtlsTeamEntity::class,BillDtlsTeamEntity::class,OrderDtlsTeamEntity::class,
    TeamAllShopDBModelEntity::class,DistWiseOrderTblEntity::class,NewGpsStatusEntity::class),
    version = 5, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun addShopEntryDao(): AddShopDao
    abstract fun userLocationDataDao(): UserLocationDataDao
    abstract fun userAttendanceDataDao(): UserAttendanceDataDao
    abstract fun shopActivityDao(): ShopActivityDao
    abstract fun stateDao(): StateListDao
    abstract fun cityDao(): CityListDao
    abstract fun marketingDetailDao(): MarketingDetailDao
    abstract fun marketingDetailImageDao(): MarketingDetailImageDao
    abstract fun marketingCategoryMasterDao(): MarketingCategoryMasterDao

    //New implementation
    abstract fun taListDao(): TaListDao

    abstract fun ppListDao(): AssignToPPDao
    abstract fun ddListDao(): AssignToDDDao
    abstract fun workTypeDao(): WorkTypeDao
    abstract fun orderListDao(): OrderListDao
    abstract fun orderDetailsListDao(): OrderDetailsListDao
    abstract fun shopVisitImageDao(): ShopVisitImageDao
    abstract fun shopVisitCompetetorImageDao(): ShopVisitCompetetorDao
    abstract fun shopVisitOrderStatusRemarksDao(): OrderStatusRemarksDao
    abstract fun shopCurrentStockEntryDao(): CurrentStockEntryDao
    abstract fun shopCurrentStockProductsEntryDao(): CurrentStockEntryProductDao
    abstract fun competetorStockEntryDao(): CompetetorStockEntryDao
    abstract fun competetorStockEntryProductDao(): CompetetorStockEntryProductDao
    abstract fun shopTypeStockViewStatusDao(): ShopTypeStockViewStatusDao
    abstract fun updateStockDao(): UpdateStockDao
    abstract fun performanceDao(): PerformanceDao
    abstract fun gpsStatusDao(): GpsStatusDao
    abstract fun collectionDetailsDao(): CollectionDetailsDao
    abstract fun inaccurateLocDao(): InAccurateLocDataDao
    abstract fun leaveTypeDao(): LeaveTypeDao
    abstract fun routeDao(): RouteDao
    abstract fun productListDao(): ProductListDao
    abstract fun orderProductListDao(): OrderProductListDao
    abstract fun stockListDao(): StockListDao
    abstract fun routeShopListDao(): RouteShopListDao
    abstract fun selectedWorkTypeDao(): SelectedWorkTypeDao
    abstract fun selectedRouteListDao(): SelectedRouteDao
    abstract fun selectedRouteShopListDao(): SelectedRouteShopListDao
    abstract fun updateOutstandingDao(): OutstandingListDao
    //abstract fun locationDao(): LocationDao
    abstract fun idleLocDao(): IdleLocDao

    abstract fun billingDao(): BillingDao
    abstract fun stockDetailsListDao(): StockDetailsListDao
    abstract fun stockProductDao(): StockProductListDao
    abstract fun billProductDao(): BillingProductListDao
    abstract fun addMeetingDao(): MeetingDao
    abstract fun addMeetingTypeDao(): MeetingTypeDao
    abstract fun productRateDao(): ProductRateDao
    abstract fun areaListDao(): AreaListDao
    abstract fun shopTypeDao(): ShopTypeDao
    abstract fun pjpListDao(): PjpListDao
    abstract fun modelListDao(): ModelDao
    abstract fun primaryAppListDao(): PrimaryAppDao
    abstract fun secondaryAppListDao(): SecondaryAppDao
    abstract fun leadTypeDao(): LeadTypeDao
    abstract fun stageDao(): StageDao
    abstract fun funnelStageDao(): FunnelStageDao
    abstract fun bsListDao(): BSListDao
    abstract fun quotDao(): QuotationDao
    abstract fun typeListDao(): TypeListDao
    abstract fun memberDao(): MemberDao
    abstract fun memberShopDao(): MemberShopDao
    abstract fun memberAreaDao(): TeamAreaDao
    abstract fun timesheetDao(): TimesheetListDao
    abstract fun clientDao(): ClientListDao
    abstract fun projectDao(): ProjectListDao
    abstract fun activityDao(): ActivityListDao
    abstract fun productDao(): TimesheetProductListDao
    abstract fun shopVisitAudioDao(): ShopVisitAudioDao
    abstract fun taskDao(): TaskDao
    abstract fun batteryNetDao(): BatteryNetStatusDao

    abstract fun activityDropdownDao(): ActivityDropDownDao
    abstract fun typeDao(): TypeDao
    abstract fun priorityDao(): PriorityDao
    abstract fun activDao(): ActivityDao

    abstract fun addDocProductDao(): AddDoctorProductListDao
    abstract fun addDocDao(): AddDoctorDao
    abstract fun addChemistProductDao(): AddChemistProductListDao
    abstract fun addChemistDao(): AddChemistDao

    abstract fun documentTypeDao(): DocumentypeDao
    abstract fun documentListDao(): DocumentListDao

    abstract fun paymenttDao(): PaymentModeDao

    abstract fun entityDao(): EntityTypeDao
    abstract fun partyStatusDao(): PartyStatusDao
    abstract fun retailerDao(): RetailerDao
    abstract fun dealerDao(): DealerDao
    abstract fun beatDao(): BeatDao
    abstract fun assignToShopDao(): AssignToShopDao

    abstract fun visitRemarksDao(): VisitRemarksDao


    //03-09-2021
    abstract fun newOrderGenderDao(): NewOrderGenderDao
    abstract fun newOrderProductDao(): NewOrderProductDao
    abstract fun newOrderColorDao(): NewOrderColorDao
    abstract fun newOrderSizeDao(): NewOrderSizeDao
    abstract fun newOrderScrOrderDao(): NewOrderScrOrderDao

    abstract fun prosDao(): ProspectDao
    abstract fun questionMasterDao(): QuestionDao
    abstract fun questionSubmitDao():  QuestionSubmitDao
    abstract fun addShopSecondaryImgDao():  AddShopSecondaryImgDao

    abstract fun returnDetailsDao():ReturnDetailsDao
    abstract fun returnProductListDao():ReturnProductListDao

    abstract fun userWiseLeaveListDao(): UserWiseLeaveListDao

    abstract fun shopFeedbackDao(): ShopFeedbackDao
    abstract fun shopFeedbackTempDao() : ShopFeedbackTepDao
    abstract fun leadActivityDao() : LeadActivityDao

    abstract fun shopDtlsTeamDao() : ShopDtlsTeamDao
    abstract fun billDtlsTeamDao() : BillDtlsTeamDao
    abstract fun orderDtlsTeamDao() : OrderDtlsTeamDao
    abstract fun collDtlsTeamDao() : CollDtlsTeamDao
    abstract fun teamAllShopDBModelDao() : TeamAllShopDBModelDao

    abstract fun distWiseOrderTblDao() : DistWiseOrderTblDao
    abstract fun newGpsStatusDao(): NewGpsStatusDao


    companion object {
        var INSTANCE: AppDatabase? = null

        fun initAppDatabase(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DBNAME)
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3,MIGRATION_3_4,MIGRATION_4_5
                    )
//                        .fallbackToDestructiveMigration()
                    .build()
            }
        }

        fun getDBInstance(): AppDatabase? {

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        val MIGRATION_1_2: Migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                /*New create table*/
                database.execSQL("CREATE TABLE tbl_shop_deefback (id INTEGER NOT NULL PRIMARY KEY , shop_id  TEXT , feedback TEXT , date_time TEXT ) ")
                database.execSQL("CREATE TABLE tbl_shop_deefback_temp (id INTEGER NOT NULL PRIMARY KEY , shop_id  TEXT , feedback TEXT , date_time TEXT ) ")
                database.execSQL("CREATE TABLE tbl_lead_activity (id INTEGER NOT NULL PRIMARY KEY , crm_id  TEXT , customer_name TEXT , mobile_no TEXT ," +
                        " activity_date  TEXT , activity_time TEXT , activity_type_name TEXT ,  activity_status  TEXT , activity_details TEXT , other_remarks TEXT , activity_next_date TEXT ) ")

            }
        }



        val MIGRATION_2_3: Migration = object : Migration(2, 3){
            override fun migrate(database: SupportSQLiteDatabase) {

                database.execSQL("CREATE TABLE bill_dtls_team (id INTEGER NOT NULL PRIMARY KEY, bill_id TEXT, invoice_no TEXT, invoice_date TEXT, " +
                        "invoice_amount TEXT, remarks TEXT, order_id TEXT, isUploaded INTEGER NOT NULL DEFAULT 0, isEditUploaded INTEGER NOT NULL DEFAULT -1, " +
                        "isDeleteUploaded INTEGER NOT NULL DEFAULT -1 , attachment TEXT , patient_no TEXT , patient_name TEXT , patient_address TEXT )")

                database.execSQL("CREATE TABLE shop_dtls_team (id INTEGER NOT NULL PRIMARY KEY, shop_id TEXT, shop_name TEXT)")

                database.execSQL("CREATE TABLE coll_dtls_team (id INTEGER NOT NULL PRIMARY KEY, date TEXT, isUploaded INTEGER NOT NULL DEFAULT 0, collection_id TEXT, " +
                        "shop_id TEXT, collection TEXT , only_time TEXT , bill_id TEXT , order_id TEXT , payment_id TEXT , instrument_no TEXT , bank TEXT , file_path TEXT , " +
                        " feedback TEXT , patient_no TEXT ,patient_name TEXT ,patient_address TEXT,Hospital TEXT,Email_Address TEXT  )")

                database.execSQL("CREATE TABLE order_dtls_team (id INTEGER NOT NULL PRIMARY KEY, date TEXT, amount TEXT, description TEXT," +
                        "isUploaded INTEGER NOT NULL DEFAULT 0, order_id TEXT, shop_id TEXT, collection TEXT, only_date TEXT, order_lat TEXT, order_long TEXT ," +
                        "remarks TEXT , signature TEXT , patient_no TEXT , patient_name TEXT , patient_address TEXT , scheme_amount TEXT , Hospital TEXT , Email_Address TEXT)")

//                database.execSQL("CREATE TABLE IF NOT EXISTS shop_detail_all_team  (shopId INTEGER NOT NULL PRIMARY KEY, shop_name TEXT, shop_id TEXT, address TEXT, " +
//                        "pin_code TEXT, owner_name TEXT, owner_contact_number TEXT,owner_email TEXT,shop_image_local_path TEXT," +
//                        "shop_image_local_path_competitor TEXT,shop_image_url TEXT,shopLat TEXT,shopLong TEXT," +
//                        " isVisited INTEGER NOT NULL DEFAULT 0,odervalue INTEGER NOT NULL DEFAULT 0,visitDate TEXT,lastVisitedDate TEXT,totalVisitCount TEXT, " +
//                        "dateOfBirth TEXT,dateOfAniversary TEXT, Duration TEXT,timeStamp TEXT,endTimeStamp TEXT, user_id TEXT,type TEXT," +
//                        "isUploaded INTEGER NOT NULL DEFAULT 0,isAddressUpdated INTEGER NOT NULL DEFAULT -1,assigned_to_dd_id TEXT," +
//                        "assigned_to_pp_id TEXT,isEditUploaded INTEGER NOT NULL DEFAULT -1,is_otp_verified TEXT,added_date TEXT,amount TEXT,entity_code TEXT,area_id TEXT," +
//                        "model_id TEXT,primary_app_id TEXT,secondary_app_id TEXT,lead_id TEXT,funnel_stage_id TEXT," +
//                        "stage_id TEXT,booking_amount TEXT,type_id TEXT,director_name TEXT,family_member_dob TEXT,person_name TEXT," +
//                        "person_no TEXT,add_dob TEXT,add_doa TEXT,doc_degree TEXT,specialization TEXT,patient_count TEXT," +
//                        "category TEXT,doc_family_dob TEXT,doc_address TEXT,doc_pincode TEXT,chamber_status INTEGER NOT NULL DEFAULT 0,remarks TEXT,chemist_name TEXT," +
//                        "chemist_address TEXT,chemist_pincode TEXT,assistant_name TEXT,assistant_no TEXT,assistant_dob TEXT,assistant_doa TEXT," +
//                        "assistant_family_dob TEXT,entity_id TEXT,party_status_id TEXT,retailer_id TEXT,dealer_id TEXT,beat_id TEXT," +
//                        "account_holder TEXT,account_no TEXT,bank_name TEXT,ifsc_code TEXT,upi_id TEXT,assigned_to_shop_id TEXT,actual_address TEXT," +
//                        "agency_name TEXT,lead_contact_number TEXT,rubylead_image1 TEXT,rubylead_image2 TEXT,project_name TEXT,landline_number TEXT," +
//                        "alternateNoForCustomer TEXT,whatsappNoForCustomer TEXT , isShopDuplicate INTEGER NOT NULL DEFAULT 0 )" )

                database.execSQL("CREATE TABLE IF NOT EXISTS `shop_detail_all_team` (`shopId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `shop_name` TEXT, `shop_id` TEXT, `address` TEXT, `pin_code` TEXT, `owner_name` TEXT, `owner_contact_number` TEXT, `owner_email` TEXT, `shop_image_local_path` TEXT, `shop_image_local_path_competitor` TEXT, `shop_image_url` TEXT, `shopLat` REAL, `shopLong` REAL, `isVisited` INTEGER, `odervalue` INTEGER NOT NULL, `visitDate` TEXT, `lastVisitedDate` TEXT, `totalVisitCount` TEXT, `dateOfBirth` TEXT, `dateOfAniversary` TEXT, `Duration` TEXT, `timeStamp` TEXT, `endTimeStamp` TEXT, `user_id` TEXT, `type` TEXT, `isUploaded` INTEGER NOT NULL, `isAddressUpdated` INTEGER NOT NULL, `assigned_to_dd_id` TEXT, `assigned_to_pp_id` TEXT, `isEditUploaded` INTEGER NOT NULL, `is_otp_verified` TEXT, `added_date` TEXT, `amount` TEXT, `entity_code` TEXT, `area_id` TEXT, `model_id` TEXT, `primary_app_id` TEXT, `secondary_app_id` TEXT, `lead_id` TEXT, `funnel_stage_id` TEXT, `stage_id` TEXT, `booking_amount` TEXT, `type_id` TEXT, `director_name` TEXT, `family_member_dob` TEXT, `person_name` TEXT, `person_no` TEXT, `add_dob` TEXT, `add_doa` TEXT, `doc_degree` TEXT, `specialization` TEXT, `patient_count` TEXT, `category` TEXT, `doc_family_dob` TEXT, `doc_address` TEXT, `doc_pincode` TEXT, `chamber_status` INTEGER NOT NULL, `remarks` TEXT, `chemist_name` TEXT, `chemist_address` TEXT, `chemist_pincode` TEXT, `assistant_name` TEXT, `assistant_no` TEXT, `assistant_dob` TEXT, `assistant_doa` TEXT, `assistant_family_dob` TEXT, `entity_id` TEXT, `party_status_id` TEXT, `retailer_id` TEXT, `dealer_id` TEXT, `beat_id` TEXT, `account_holder` TEXT, `account_no` TEXT, `bank_name` TEXT, `ifsc_code` TEXT, `upi_id` TEXT, `assigned_to_shop_id` TEXT, `actual_address` TEXT, `agency_name` TEXT, `lead_contact_number` TEXT, `rubylead_image1` TEXT, `rubylead_image2` TEXT, `project_name` TEXT, `landline_number` TEXT, `alternateNoForCustomer` TEXT, `whatsappNoForCustomer` TEXT, `isShopDuplicate` INTEGER NOT NULL)");


                database.execSQL("CREATE TABLE tbl_dist_wise_ord_report (id INTEGER NOT NULL PRIMARY KEY, from_date TEXT, to_date TEXT, selected_dd TEXT, selected_pp TEXT, " +
                        "genereated_date_time TEXT, only_date TEXT)")

                database.execSQL("ALTER TABLE shop_detail ADD COLUMN isShopDuplicate INTEGER NOT NULL DEFAULT 0 ")
                database.execSQL("alter table shop_detail ADD COLUMN purpose TEXT")
                database.execSQL("alter table new_order_entry ADD COLUMN rate TEXT NOT NULL DEFAULT '0' ")


            }
        }

        val MIGRATION_3_4: Migration = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE battery_net_status_list ADD COLUMN Available_Storage TEXT ")
                database.execSQL("ALTER TABLE  battery_net_status_list ADD COLUMN Total_Storage TEXT")
                database.execSQL("ALTER TABLE battery_net_status_list ADD COLUMN Power_Saver_Status TEXT NOT NULL DEFAULT 'Off' ")
                database.execSQL("create TABLE new_gps_status  (id INTEGER NOT NULL PRIMARY KEY , date_time  TEXT , gps_service_status TEXT, network_status  TEXT , isUploaded INTEGER NOT NULL DEFAULT 0) ")
            }
        }

        val MIGRATION_4_5: Migration = object : Migration(4,5) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE shop_detail ADD COLUMN isOwnshop INTEGER NOT NULL DEFAULT 1 ")
                database.execSQL("CREATE INDEX ACTIVITYID ON shop_activity (shopActivityId,shopid,visited_date)")
                database.execSQL("CREATE INDEX ACTIVITY_ID_DATE ON shop_activity (shopid,visited_date)")
                database.execSQL("alter table shop_detail ADD COLUMN GSTN_Number TEXT")
                database.execSQL("alter table shop_detail ADD COLUMN ShopOwner_PAN TEXT")


            }
        }


    }


//}


}