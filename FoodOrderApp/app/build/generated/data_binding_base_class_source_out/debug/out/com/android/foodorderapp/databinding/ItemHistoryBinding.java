// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.android.foodorderapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemHistoryBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CircleImageView imgUserComment;

  @NonNull
  public final TextView txtAddressItem;

  @NonNull
  public final TextView txtListItem;

  @NonNull
  public final TextView txtNameItem;

  @NonNull
  public final TextView txtPhiItem;

  @NonNull
  public final TextView txtTongItem;

  @NonNull
  public final TextView txtTongSoLuongItem;

  @NonNull
  public final TextView txtTongTienSPItem;

  private ItemHistoryBinding(@NonNull CardView rootView, @NonNull CircleImageView imgUserComment,
      @NonNull TextView txtAddressItem, @NonNull TextView txtListItem,
      @NonNull TextView txtNameItem, @NonNull TextView txtPhiItem, @NonNull TextView txtTongItem,
      @NonNull TextView txtTongSoLuongItem, @NonNull TextView txtTongTienSPItem) {
    this.rootView = rootView;
    this.imgUserComment = imgUserComment;
    this.txtAddressItem = txtAddressItem;
    this.txtListItem = txtListItem;
    this.txtNameItem = txtNameItem;
    this.txtPhiItem = txtPhiItem;
    this.txtTongItem = txtTongItem;
    this.txtTongSoLuongItem = txtTongSoLuongItem;
    this.txtTongTienSPItem = txtTongTienSPItem;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemHistoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_history, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemHistoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgUserComment;
      CircleImageView imgUserComment = rootView.findViewById(id);
      if (imgUserComment == null) {
        break missingId;
      }

      id = R.id.txtAddressItem;
      TextView txtAddressItem = rootView.findViewById(id);
      if (txtAddressItem == null) {
        break missingId;
      }

      id = R.id.txtListItem;
      TextView txtListItem = rootView.findViewById(id);
      if (txtListItem == null) {
        break missingId;
      }

      id = R.id.txtNameItem;
      TextView txtNameItem = rootView.findViewById(id);
      if (txtNameItem == null) {
        break missingId;
      }

      id = R.id.txtPhiItem;
      TextView txtPhiItem = rootView.findViewById(id);
      if (txtPhiItem == null) {
        break missingId;
      }

      id = R.id.txtTongItem;
      TextView txtTongItem = rootView.findViewById(id);
      if (txtTongItem == null) {
        break missingId;
      }

      id = R.id.txtTongSoLuongItem;
      TextView txtTongSoLuongItem = rootView.findViewById(id);
      if (txtTongSoLuongItem == null) {
        break missingId;
      }

      id = R.id.txtTongTienSPItem;
      TextView txtTongTienSPItem = rootView.findViewById(id);
      if (txtTongTienSPItem == null) {
        break missingId;
      }

      return new ItemHistoryBinding((CardView) rootView, imgUserComment, txtAddressItem,
          txtListItem, txtNameItem, txtPhiItem, txtTongItem, txtTongSoLuongItem, txtTongTienSPItem);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}