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
    ,ReturnProductListEntity::class,UserWiseLeaveListEntity::class,
    LeadActivityEntity::class,ShopFeedbackEntity::class,ShopFeedbackTempEntity::class),
    version = 2, exportSchema = false)
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


    companion object {
        var INSTANCE: AppDatabase? = null

        fun initAppDatabase(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DBNAME)
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
//                        .fallbackToDestructiveMigration()
                    .build()
            }
        }

        fun getDBInstance(): AppDatabase? {

            return INSTANCE
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

        fun destroyInstance() {
            INSTANCE = null
        }


    }


//}


}