package io.github.daduam;

import java.util.Comparator;
import java.util.Optional;

import io.github.daduam.data.ListItemData;
import io.github.daduam.models.ListItem;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListVizController {

  @FXML
  private TextField newItemTextField;

  @FXML
  private Button addButton;

  @FXML
  private Button removeButton;

  @FXML
  private ListView<ListItem> listView;

  public void initialize() {
    SortedList<ListItem> sortedItems = new SortedList<ListItem>(ListItemData.getInstance().getListItems(),
        new Comparator<ListItem>() {
          @Override
          public int compare(ListItem a, ListItem b) {
            return a.getText().toLowerCase().compareTo(b.getText().toLowerCase());
          }
        });

    listView.setItems(sortedItems);
  }

  @FXML
  private void handleAddButtonAction() {
    String item = newItemTextField.getText();
    if (!item.isBlank()) {
      ListItemData.getInstance().addListItem(new ListItem(item));
      newItemTextField.clear();
    }
  }

  @FXML
  private void handleRemoveButtonAction() {
    ListItem selectedItem = listView.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      deleteListItem(selectedItem);
    }
  }

  private void deleteListItem(ListItem item) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirm delete");
    alert.setHeaderText("Deleting \"" + item + "\"");
    alert.setContentText("Press OK to delete list item");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      ListItemData.getInstance().deleteListItem(item);
    }
  }

}
