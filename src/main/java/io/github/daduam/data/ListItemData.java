package io.github.daduam.data;

import io.github.daduam.models.ListItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListItemData {
  private static ListItemData instance = new ListItemData();

  private ObservableList<ListItem> listItems;

  public ListItemData() {
    listItems = FXCollections.observableArrayList();
  }

  public static ListItemData getInstance() {
    return instance;
  }

  public ObservableList<ListItem> getListItems() {
    return listItems;
  }

  public void addListItem(ListItem item) {
    listItems.add(item);
  }

  public void deleteListItem(ListItem item) {
    listItems.remove(item);
  }
}
