package com.astooltech.advancedview.proteus.parser;

import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.google.gson.annotations.SerializedName;

public class DataValueSelect {
    // @SerializedName("ID_group")
    // @Expose

    // private Integer iDGroup;
    // @SerializedName("name__group")
    @SerializedName("data_id")
    private String iDUnit;
    @SerializedName("data_set")
    private String unitName;

    public ObjectValue getAnotherDatat() {
        return anotherDatat;
    }

    public void setAnotherDatat(ObjectValue anotherDatat) {
        this.anotherDatat = anotherDatat;
    }

    private ObjectValue anotherDatat;
    public int getIdexid() {
        return idexid;
    }

    public void setIdexid(int idexid) {
        this.idexid = idexid;
    }

    @SerializedName("data_setint")
    private int idexid;

    public String getTypselect() {
        return typselect;
    }

    public void setTypselect(String typselect) {
        this.typselect = typselect;
    }

    private String typselect;
    public boolean isChecknull() {
        return checknull;
    }

    public void setChecknull(boolean checknull) {
        this.checknull = checknull;
    }

    private  boolean checknull=false;
    public String getDataGet() {
        return DataGet;
    }

    public void setDataGet(String dataGet) {
        DataGet = dataGet;
    }

    public Value getCustomevalue() {
        return customevalue;
    }

    public void setCustomevalue(Value customevalue) {
        this.customevalue = customevalue;
    }

    private Value customevalue;
    @SerializedName("data_get")
    private String DataGet;
    /**
     * No args constructor for use in serialization
     *
     */
    public DataValueSelect() {
        this.idexid=0;

    }

    /**
     *
     * @param unitName
     * @param iDUnit
     */
    public DataValueSelect(String iDUnit, String unitName,String datge) {
        super();
        this.idexid=0;
        this.typselect="0";
        this.iDUnit = iDUnit;
        this.unitName = unitName;
        this.DataGet=datge;
        this.anotherDatat=new ObjectValue();
        this.customevalue=new Primitive("f");
    }
    public DataValueSelect(String iDUnit, String unitName,String datge,int indd) {
        super();
        this.idexid=indd;
      //  this.typselect="0";
        this.iDUnit = iDUnit;
        this.unitName = unitName;
        this.DataGet=datge;
        this.anotherDatat=new ObjectValue();
        this.customevalue=new Primitive("f");
    }
    public DataValueSelect(String iDUnit, String unitName,String datge,int indd,String typse) {
        super();
        this.idexid=indd;
        this.typselect=typse;
        this.iDUnit = iDUnit;
        this.anotherDatat=new ObjectValue();
        this.unitName = unitName;
        this.DataGet=datge;
        this.customevalue=new Primitive("f");
    }
    public DataValueSelect(String iDUnit, String unitName,String datge,int indd,String typse,ObjectValue ob) {
        super();
        this.idexid=indd;
        this.typselect=typse;
        this.iDUnit = iDUnit;
        this.anotherDatat=ob;
        this.unitName = unitName;
        this.DataGet=datge;
        this.customevalue=new Primitive("f");
    }
    public String getIDUnit() {
        return iDUnit;
    }

    public void setIDUnit(String iDUnit) {
        this.iDUnit = iDUnit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

}
