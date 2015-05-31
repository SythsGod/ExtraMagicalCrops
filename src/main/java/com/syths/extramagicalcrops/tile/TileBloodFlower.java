package com.syths.extramagicalcrops.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileBloodFlower extends TileEntity implements IFluidHandler{
	
	public int capacity;
	public FluidTank buffer;
	
	public TileBloodFlower() {
		capacity = 2000;
		buffer = new FluidTank(capacity);
	}
	
	@Override
	public void updateEntity() {
		if (worldObj.getWorldTime() % 50 == 0) worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	@Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        return buffer.fill(resource, doFill);
    }
	
	@Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return buffer.drain(resource.amount, doDrain);
    }
	
	@Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return buffer.drain(maxDrain, doDrain);
    }
	
	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from){
		return new FluidTankInfo[]{buffer.getInfo()};
		}
	
	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}
	
	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}
}