/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * hu.billcity.domain.Item
 * <ClassDescription>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version Feb 2016
 * @since 1.8
 */

public class Item {
    protected long itemId;
    protected String itemCode;
    protected String name;
    protected String groupName;
    protected boolean isTracked;
    protected String purchaseTaxCode;
    protected String salesTaxCode;
    protected String salesItemCode;
    protected String barcode;
    protected String purchaseItemCode;
    protected String statCode;
    protected String unit;

    /*
     * java.sql.Timestamp provides a good Date and Time data
     * Reference:
     *  http://stackoverflow.com/questions/32202155/java-simpledateformat-correct-format-for-postgres-timestamp-with-timezone-da
     *
     */
    protected Timestamp timeCreated;

    // The user who created the item entry
    protected String userAccountable;

    protected Timestamp lastModified;
    protected String modifiedBy;
    protected String description;
    protected boolean isArchived;
    protected String priceGroup;
    protected String defPurchasedPrice;
    protected double netWeight;
    protected double grossWeight;

    /**
     * Examples: Gram = 0, Kg = 1, Ton = 2
     */
    protected int weightUnit;

    protected ArrayList<ItemUnitExchange> itemQuantities;
    protected boolean serialNumberNotMandatory;

    /**
     * Examples:  Bulk = 0; serialNumber = 1;
     * <p>
     * TODO: LotSzamos = 2
     */
    protected int serialNumber = -1;

    protected byte[] pictureBlob;

    protected double minStock;
    protected double maxStock;
    protected double optimalStock;

    public Item() {
        this(
                "", "", "", false, "", "", "",
                "", "", "", "", Timestamp.valueOf(LocalDateTime.now()), "",
                Timestamp.valueOf(LocalDateTime.now()), "", "", false, "",
                -1, "", 0, 0, 0,
                new ArrayList<>(), false, -1, null,
                -1, -1, -1
        );
    }

    public Item(String itemCode, String name, String groupName, boolean isTracked, String purchasedTaxCode, String salesTaxCode, String salesItemCode,
                String barcode, String purchaseItemCode, String statCode, String unit, Timestamp timeCreated, String createdBy,
                Timestamp lastModified, String modifiedBy, String description, boolean isArchived, String priceGroup,
                int defTransporterId, String defPurchasedPrice, double netWeight, double grossWeight, int weightUnit,
                ArrayList<ItemUnitExchange> itemQuantities, boolean serialNumberNotMandatory, int serialNumber, byte[] pictureBlob,
                double minStock, double maxStock, double optimalStock) {

        this.itemCode = itemCode;
        this.name = name;
        this.groupName = groupName;

        this.isTracked = isTracked; // formerly type

        this.purchaseTaxCode = purchasedTaxCode;
        this.salesTaxCode = salesTaxCode;
        this.salesItemCode = salesItemCode;
        this.barcode = barcode;
        this.purchaseItemCode = purchaseItemCode;
        this.statCode = statCode;
        this.unit = unit;
        this.timeCreated = timeCreated;
        this.userAccountable = createdBy;
        this.lastModified = lastModified;
        this.modifiedBy = modifiedBy;
        this.description = description;
        this.isArchived = isArchived;
        this.priceGroup = priceGroup;
        this.defPurchasedPrice = defPurchasedPrice;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.weightUnit = weightUnit;
        this.itemQuantities = itemQuantities;
        this.serialNumberNotMandatory = serialNumberNotMandatory;
        this.serialNumber = serialNumber;
        this.pictureBlob = pictureBlob;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.optimalStock = optimalStock;
    }

    public long getItemId() {
        return itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPurchaseTaxCode() {
        return purchaseTaxCode;
    }

    public void setPurchaseTaxCode(String purchaseTaxCode) {
        this.purchaseTaxCode = purchaseTaxCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isTracked() {
        return isTracked;
    }

    public void setTracked(boolean tracked) {
        isTracked = tracked;
    }

    public String getPurchasedTaxCode() {
        return purchaseTaxCode;
    }

    public void setPurchasedTaxCode(String purchasedTaxCode) {
        this.purchaseTaxCode = purchasedTaxCode;
    }

    public String getSalesTaxCode() {
        return salesTaxCode;
    }

    public void setSalesTaxCode(String salesTaxCode) {
        this.salesTaxCode = salesTaxCode;
    }

    public String getSalesItemCode() {
        return salesItemCode;
    }

    public void setSalesItemCode(String salesItemCode) {
        this.salesItemCode = salesItemCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPurchaseItemCode() {
        return purchaseItemCode;
    }

    public void setPurchaseItemCode(String purchaseItemCode) {
        this.purchaseItemCode = purchaseItemCode;
    }

    public String getStatCode() {
        return statCode;
    }

    public void setStatCode(String statCode) {
        this.statCode = statCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getUserAccountable() {
        return userAccountable;
    }

    public void setUserAccountable(String userAccountable) {
        this.userAccountable = userAccountable;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(String priceGroup) {
        this.priceGroup = priceGroup;
    }

    public String getDefPurchasedPrice() {
        return defPurchasedPrice;
    }

    public void setDefPurchasedPrice(String defPurchasedPrice) {
        this.defPurchasedPrice = defPurchasedPrice;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public int getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(int weightUnit) {
        this.weightUnit = weightUnit;
    }

    public ArrayList<ItemUnitExchange> getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(ArrayList<ItemUnitExchange> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }

    public boolean isSerialNumberNotMandatory() {
        return serialNumberNotMandatory;
    }

    public void setSerialNumberNotMandatory(boolean serialNumberNotMandatory) {
        this.serialNumberNotMandatory = serialNumberNotMandatory;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public byte[] getPictureBlob() {
        return pictureBlob;
    }

    public void setPictureBlob(byte[] pictureBlob) {
        this.pictureBlob = pictureBlob;
    }

    public double getMinStock() {
        return minStock;
    }

    public void setMinStock(double minStock) {
        this.minStock = minStock;
    }

    public double getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(double maxStock) {
        this.maxStock = maxStock;
    }

    public double getOptimalStock() {
        return optimalStock;
    }

    public void setOptimalStock(double optimalStock) {
        this.optimalStock = optimalStock;
    }

    public static class ItemUnitExchange {
        protected long itemId;
        protected double quantity;

        public ItemUnitExchange() {
            this(-1, 0.0);
        }

        public ItemUnitExchange(long itemId, double quantity) {
            this.itemId = itemId;
            this.quantity = quantity;
        }
    }
}
