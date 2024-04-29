package view;

import model.photoAlbum.IAlbum;

/**
 * The interface Web view.
 */
public interface IWebView {
  /**
   * Generate web view.
   *
   * @param model the model
   */
  void generateWebView(IAlbum model);
}