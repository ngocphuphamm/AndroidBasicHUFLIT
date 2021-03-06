// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.android.foodorderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Care;

  @NonNull
  public final TextView Member;

  @NonNull
  public final Button button;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageView imageCare;

  @NonNull
  public final ImageView imageMember;

  @NonNull
  public final ImageView imagePromotion;

  @NonNull
  public final ImageView imageShare;

  @NonNull
  public final ImageView imageView8;

  @NonNull
  public final ImageView imageView9;

  @NonNull
  public final TextView promotion;

  @NonNull
  public final TextView share;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  private ActivityProfileBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Care,
      @NonNull TextView Member, @NonNull Button button, @NonNull ConstraintLayout constraintLayout,
      @NonNull ImageView imageCare, @NonNull ImageView imageMember,
      @NonNull ImageView imagePromotion, @NonNull ImageView imageShare,
      @NonNull ImageView imageView8, @NonNull ImageView imageView9, @NonNull TextView promotion,
      @NonNull TextView share, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull TextView textView4) {
    this.rootView = rootView;
    this.Care = Care;
    this.Member = Member;
    this.button = button;
    this.constraintLayout = constraintLayout;
    this.imageCare = imageCare;
    this.imageMember = imageMember;
    this.imagePromotion = imagePromotion;
    this.imageShare = imageShare;
    this.imageView8 = imageView8;
    this.imageView9 = imageView9;
    this.promotion = promotion;
    this.share = share;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Care;
      TextView Care = rootView.findViewById(id);
      if (Care == null) {
        break missingId;
      }

      id = R.id.Member;
      TextView Member = rootView.findViewById(id);
      if (Member == null) {
        break missingId;
      }

      id = R.id.button;
      Button button = rootView.findViewById(id);
      if (button == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = rootView.findViewById(id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.imageCare;
      ImageView imageCare = rootView.findViewById(id);
      if (imageCare == null) {
        break missingId;
      }

      id = R.id.imageMember;
      ImageView imageMember = rootView.findViewById(id);
      if (imageMember == null) {
        break missingId;
      }

      id = R.id.imagePromotion;
      ImageView imagePromotion = rootView.findViewById(id);
      if (imagePromotion == null) {
        break missingId;
      }

      id = R.id.imageShare;
      ImageView imageShare = rootView.findViewById(id);
      if (imageShare == null) {
        break missingId;
      }

      id = R.id.imageView8;
      ImageView imageView8 = rootView.findViewById(id);
      if (imageView8 == null) {
        break missingId;
      }

      id = R.id.imageView9;
      ImageView imageView9 = rootView.findViewById(id);
      if (imageView9 == null) {
        break missingId;
      }

      id = R.id.promotion;
      TextView promotion = rootView.findViewById(id);
      if (promotion == null) {
        break missingId;
      }

      id = R.id.share;
      TextView share = rootView.findViewById(id);
      if (share == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = rootView.findViewById(id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = rootView.findViewById(id);
      if (textView4 == null) {
        break missingId;
      }

      return new ActivityProfileBinding((ConstraintLayout) rootView, Care, Member, button,
          constraintLayout, imageCare, imageMember, imagePromotion, imageShare, imageView8,
          imageView9, promotion, share, textView2, textView3, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
