// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.android.foodorderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MenuRecyclerRowBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout addMoreLayout;

  @NonNull
  public final TextView addToCartButton;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView imageAddOne;

  @NonNull
  public final ImageView imageMinus;

  @NonNull
  public final TextView menuName;

  @NonNull
  public final TextView menuPrice;

  @NonNull
  public final ImageView thumbImage;

  @NonNull
  public final TextView tvCount;

  private MenuRecyclerRowBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout addMoreLayout, @NonNull TextView addToCartButton,
      @NonNull CardView cardView, @NonNull ImageView imageAddOne, @NonNull ImageView imageMinus,
      @NonNull TextView menuName, @NonNull TextView menuPrice, @NonNull ImageView thumbImage,
      @NonNull TextView tvCount) {
    this.rootView = rootView;
    this.addMoreLayout = addMoreLayout;
    this.addToCartButton = addToCartButton;
    this.cardView = cardView;
    this.imageAddOne = imageAddOne;
    this.imageMinus = imageMinus;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.thumbImage = thumbImage;
    this.tvCount = tvCount;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MenuRecyclerRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MenuRecyclerRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.menu_recycler_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MenuRecyclerRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addMoreLayout;
      LinearLayout addMoreLayout = rootView.findViewById(id);
      if (addMoreLayout == null) {
        break missingId;
      }

      id = R.id.addToCartButton;
      TextView addToCartButton = rootView.findViewById(id);
      if (addToCartButton == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = rootView.findViewById(id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.imageAddOne;
      ImageView imageAddOne = rootView.findViewById(id);
      if (imageAddOne == null) {
        break missingId;
      }

      id = R.id.imageMinus;
      ImageView imageMinus = rootView.findViewById(id);
      if (imageMinus == null) {
        break missingId;
      }

      id = R.id.menuName;
      TextView menuName = rootView.findViewById(id);
      if (menuName == null) {
        break missingId;
      }

      id = R.id.menuPrice;
      TextView menuPrice = rootView.findViewById(id);
      if (menuPrice == null) {
        break missingId;
      }

      id = R.id.thumbImage;
      ImageView thumbImage = rootView.findViewById(id);
      if (thumbImage == null) {
        break missingId;
      }

      id = R.id.tvCount;
      TextView tvCount = rootView.findViewById(id);
      if (tvCount == null) {
        break missingId;
      }

      return new MenuRecyclerRowBinding((ConstraintLayout) rootView, addMoreLayout, addToCartButton,
          cardView, imageAddOne, imageMinus, menuName, menuPrice, thumbImage, tvCount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
