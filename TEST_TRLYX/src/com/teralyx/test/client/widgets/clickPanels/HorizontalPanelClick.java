package com.teralyx.test.client.widgets.clickPanels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class HorizontalPanelClick extends HorizontalPanel implements
		HasClickHandlers {

	public HorizontalPanelClick() {
        super();
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

}
