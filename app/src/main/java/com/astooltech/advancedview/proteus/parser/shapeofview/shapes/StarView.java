package com.astooltech.advancedview.proteus.parser.shapeofview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.parser.shapeofview.ShapeOfView;
import com.astooltech.advancedview.proteus.parser.shapeofview.manager.ClipPathManager;

public class StarView extends ShapeOfView  {

    private int noOfPoints = 5;
private  int typda=0;
    public StarView(@NonNull Context context) {
        super(context);
        init(context, null);
    }
public  void setType(int typdaa){
        typda=typdaa;
        invalidate();

}
    public StarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if(typda==0) {
            init(context, attrs);
        }
        else if(typda==2){

            initPlo(context, attrs);
        }
        else if(typda==3){

            initArc(context, attrs);
        }
        else{
            initPlogon(context, attrs);
        }
    }

    public StarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(typda==0) {
            init(context, attrs);
        }
        else if(typda==2){

            initPlo(context, attrs);
        }
        else if(typda==3){

            initArc(context, attrs);
        }

        else{
            initPlogon(context, attrs);
        }
    }

    public  void Setda(int nog){
        noOfPoints=nog;
        invalidate();

    }
    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.StarView);
            final int points = attributes.getInteger(R.styleable.StarView_shape_star_noOfPoints, noOfPoints);
            noOfPoints = points > 2? points : noOfPoints;
            attributes.recycle();
        }

        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            @Override
            public Path createClipPath(int width, int height) {

                final int vertices = noOfPoints * 2;
                final float alpha = (float)(2 * Math.PI) / vertices;
                final int radius = (height <= width? height : width) / 2;
                final float centerX = width / 2;
                final float centerY = height / 2;

                final Path path = new Path();
                for (int i = vertices + 1; i != 0; i--) {
                    float r = radius * (i % 2 + 1) / 2;
                    double omega = alpha * i;
                    path.lineTo((float)(r * Math.sin(omega)) + centerX, (float)(r * Math.cos(omega)) + centerY);
                }
                path.close();
                return path;
            }

            @Override
            public boolean requiresBitmap() {
                return true;
            }
        });
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
        requiresShapeUpdate();
    }
    private int numberOfSides = 4;
    public int getNoOfPoints() { return noOfPoints; }


   //plgon
    public int getNoOfSides() {
        return numberOfSides;
    }

    public void setNoOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        requiresShapeUpdate();
    }



    private void initPlogon(Context context, AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.PolygonView);
            final int sides = attributes.getInteger(R.styleable.PolygonView_shape_polygon_noOfSides, numberOfSides);

            numberOfSides = sides > 3 ? sides : numberOfSides;
            attributes.recycle();
        }

        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            @Override
            public Path createClipPath(int width, int height) {

                final float section = (float) (2.0 * Math.PI / numberOfSides);
                final int polygonSize = Math.min(width, height);
                final int radius = polygonSize / 2;
                final int centerX = width / 2;
                final int centerY = height / 2;

                final Path polygonPath = new Path();
                polygonPath.moveTo((centerX + radius * (float) Math.cos(0)), (centerY + radius * (float) Math.sin(0)));

                for (int i = 1; i < numberOfSides; i++) {
                    polygonPath.lineTo((centerX + radius * (float) Math.cos(section * i)),
                            (centerY + radius * (float) Math.sin(section * i)));
                }

                polygonPath.close();
                return polygonPath;
            }

            @Override
            public boolean requiresBitmap() {
                return true;
            }
        });
    }///////////


    //Boble
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_TOP = 2;
    public static final int POSITION_LEFT = 3;
    public static final int POSITION_RIGHT = 4;


      @Position
    private int position = POSITION_BOTTOM;

    private float borderRadiusPx;
    private float arrowHeightPx;
    private float arrowWidthPx;

    private float defPositionPer=0.5f;
    private float positionPer;
    private void initPlo(Context context, AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.BubbleView);
            borderRadiusPx = attributes.getDimensionPixelSize(R.styleable.BubbleView_shape_bubble_borderRadius, (int) dpToPx(10));
            position = attributes.getInteger(R.styleable.BubbleView_shape_bubble_arrowPosition, position);
            arrowHeightPx = attributes.getDimensionPixelSize(R.styleable.BubbleView_shape_bubble_arrowHeight, (int) dpToPx(10));
            arrowWidthPx = attributes.getDimensionPixelSize(R.styleable.BubbleView_shape_bubble_arrowWidth, (int) dpToPx(10));
            positionPer=attributes.getFloat(R.styleable.BubbleView_arrow_posititon_percent,defPositionPer);
            attributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            @Override
            public Path createClipPath(int width, int height) {
                final RectF myRect = new RectF(0, 0, width, height);
                return drawBubble(myRect, borderRadiusPx, borderRadiusPx, borderRadiusPx, borderRadiusPx);
            }

            @Override
            public boolean requiresBitmap() {
                return false;
            }
        });
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(@Position int position) {
        this.position = position;
        requiresShapeUpdate();
    }

    public float getBorderRadius() {
        return borderRadiusPx;
    }

    public float getBorderRadiusDp() {
        return pxToDp(getBorderRadius());
    }

    public void setBorderRadius(float borderRadius) {
        this.borderRadiusPx = borderRadius;
        requiresShapeUpdate();
    }

    public void setBorderRadiusDp(float borderRadius) {
        this.borderRadiusPx = dpToPx(borderRadius);
        requiresShapeUpdate();
    }

    public float getArrowHeight() {
        return arrowHeightPx;
    }

    public float getArrowHeightDp() {
        return pxToDp(getArrowHeight());
    }

    public void setArrowHeight(float arrowHeight) {
        this.arrowHeightPx = arrowHeight;
        requiresShapeUpdate();
    }

    public void setArrowHeightDp(float arrowHeight) {
        setArrowHeight(dpToPx(arrowHeight));
    }

    public float getArrowWidth() {
        return arrowWidthPx;
    }

    public void setArrowWidth(float arrowWidth) {
        this.arrowWidthPx = arrowWidth;
        requiresShapeUpdate();
    }

    public void setArrowWidthDp(float arrowWidth) {
        setArrowWidth(dpToPx(arrowWidth));
    }


    public void setPositionPer(float positionPer) {
        this.positionPer = positionPer;
        requiresShapeUpdate();
    }

    private Path drawBubble(RectF myRect, float topLeftDiameter, float topRightDiameter, float bottomRightDiameter, float bottomLeftDiameter) {
        final Path path = new Path();

        topLeftDiameter = topLeftDiameter < 0 ? 0 : topLeftDiameter;
        topRightDiameter = topRightDiameter < 0 ? 0 : topRightDiameter;
        bottomLeftDiameter = bottomLeftDiameter < 0 ? 0 : bottomLeftDiameter;
        bottomRightDiameter = bottomRightDiameter < 0 ? 0 : bottomRightDiameter;

        final float spacingLeft = this.position == POSITION_LEFT ? arrowHeightPx : 0;
        final float spacingTop = this.position == POSITION_TOP ? arrowHeightPx : 0;
        final float spacingRight = this.position == POSITION_RIGHT ? arrowHeightPx : 0;
        final float spacingBottom = this.position == POSITION_BOTTOM ? arrowHeightPx : 0;

        final float left = spacingLeft + myRect.left;
        final float top = spacingTop + myRect.top;
        final float right = myRect.right - spacingRight;
        final float bottom = myRect.bottom - spacingBottom;

        final float centerX = (myRect.left + myRect.right) * positionPer;

        path.moveTo(left + topLeftDiameter / 2f, top);
        //LEFT, TOP

        if (position == POSITION_TOP) {
            path.lineTo(centerX - arrowWidthPx, top);
            path.lineTo(centerX, myRect.top);
            path.lineTo(centerX + arrowWidthPx, top);
        }
        path.lineTo(right - topRightDiameter / 2f, top);

        path.quadTo(right, top, right, top + topRightDiameter / 2);
        //RIGHT, TOP

        if (position == POSITION_RIGHT) {
            path.lineTo(right, bottom-(bottom*(1-positionPer))- arrowWidthPx);
            path.lineTo(myRect.right, bottom-(bottom*(1-positionPer)));
            path.lineTo(right, bottom-(bottom*(1-positionPer)) + arrowWidthPx);
        }
        path.lineTo(right, bottom - bottomRightDiameter / 2);

        path.quadTo(right, bottom, right - bottomRightDiameter / 2, bottom);
        //RIGHT, BOTTOM

        if (position == POSITION_BOTTOM) {
            path.lineTo(centerX + arrowWidthPx, bottom);
            path.lineTo(centerX, myRect.bottom);
            path.lineTo(centerX - arrowWidthPx, bottom);
        }
        path.lineTo(left + bottomLeftDiameter / 2, bottom);

        path.quadTo(left, bottom, left, bottom - bottomLeftDiameter / 2);
        //LEFT, BOTTOM

        if (position == POSITION_LEFT) {
            path.lineTo(left, bottom-(bottom*(1-positionPer))+ arrowWidthPx);
            path.lineTo(myRect.left, bottom-(bottom*(1-positionPer)));
            path.lineTo(left, bottom-(bottom*(1-positionPer)) - arrowWidthPx);
        }
        path.lineTo(left, top + topLeftDiameter / 2);

        path.quadTo(left, top, left + topLeftDiameter / 2, top);

        path.close();

        return path;
    }

    @IntDef({POSITION_LEFT, POSITION_RIGHT, POSITION_TOP, POSITION_BOTTOM})
    public @interface Position {
    }
///Arc

    public static final int CROP_INSIDE = 1;
    public static final int CROP_OUTSIDE = 2;
    private float arcHeightPx = 0f;
    private void initArc(Context context, AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ArcView);
            arcHeightPx = attributes.getDimensionPixelSize(R.styleable.ArcView_shape_arc_height, (int) arcHeightPx);
            position = attributes.getInteger(R.styleable.ArcView_shape_arc_position,  position);
            attributes.recycle();
        }
        super.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            @Override
            public Path createClipPath(int width, int height) {
                final Path path = new Path();

                final boolean isCropInside = getCropDirection() == CROP_INSIDE;

                final float arcHeightAbs = Math.abs(arcHeightPx);

                switch (position) {
                    case POSITION_BOTTOM: {
                        if (isCropInside) {
                            path.moveTo(0, 0);
                            path.lineTo(0, height);
                            path.quadTo(width / 2, height - 2 * arcHeightAbs, width, height);
                            path.lineTo(width, 0);
                            path.close();
                        } else {
                            path.moveTo(0, 0);
                            path.lineTo(0, height - arcHeightAbs);
                            path.quadTo(width / 2, height + arcHeightAbs, width, height - arcHeightAbs);
                            path.lineTo(width, 0);
                            path.close();
                        }
                        break;
                    }
                    case POSITION_TOP:
                        if (isCropInside) {
                            path.moveTo(0, height);
                            path.lineTo(0, 0);
                            path.quadTo(width / 2, 2 * arcHeightAbs, width, 0);
                            path.lineTo(width, height);
                            path.close();
                        } else {
                            path.moveTo(0, arcHeightAbs);
                            path.quadTo(width / 2, -arcHeightAbs, width, arcHeightAbs);
                            path.lineTo(width, height);
                            path.lineTo(0, height);
                            path.close();
                        }
                        break;
                    case POSITION_LEFT:
                        if (isCropInside) {
                            path.moveTo(width, 0);
                            path.lineTo(0, 0);
                            path.quadTo(arcHeightAbs * 2, height / 2, 0, height);
                            path.lineTo(width, height);
                            path.close();
                        } else {
                            path.moveTo(width, 0);
                            path.lineTo(arcHeightAbs, 0);
                            path.quadTo(-arcHeightAbs, height / 2, arcHeightAbs, height);
                            path.lineTo(width, height);
                            path.close();
                        }
                        break;
                    case POSITION_RIGHT:
                        if (isCropInside) {
                            path.moveTo(0, 0);
                            path.lineTo(width, 0);
                            path.quadTo(width - arcHeightAbs * 2, height / 2, width, height);
                            path.lineTo(0, height);
                            path.close();
                        } else {
                            path.moveTo(0, 0);
                            path.lineTo(width - arcHeightAbs, 0);
                            path.quadTo(width + arcHeightAbs, height / 2, width - arcHeightAbs, height);
                            path.lineTo(0, height);
                            path.close();
                        }
                        break;

                }
                return path;
            }

            @Override
            public boolean requiresBitmap() {
                return false;
            }
        });
    }

    public float getArcHeight() {
        return arcHeightPx;
    }

    public void setArcHeight(float arcHeight) {
        this.arcHeightPx = arcHeight;
        requiresShapeUpdate();
    }

    public float getArcHeightDp() {
        return pxToDp(arcHeightPx);
    }

    public void setArcHeightDp(float arcHeight) {
        this.setArcHeight(dpToPx(arcHeight));
    }

    public int getCropDirection() {
        return arcHeightPx > 0 ? CROP_OUTSIDE : CROP_INSIDE ;
    }

    @IntDef(value = {CROP_INSIDE, CROP_OUTSIDE})
    public @interface CropDirection {
    }

}
