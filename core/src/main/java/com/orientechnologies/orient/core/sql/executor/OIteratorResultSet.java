package com.orientechnologies.orient.core.sql.executor;

import com.orientechnologies.orient.core.db.record.OIdentifiable;

import java.util.Iterator;

/**
 * Created by luigidellaquila on 07/07/16.
 */
public class OIteratorResultSet implements OTodoResultSet {
  private final Iterator iterator;

  public OIteratorResultSet(Iterator iter) {
    this.iterator = iter;
  }

  @Override public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override public OResult next() {
    Object val = iterator.next();
    if (val instanceof OResult) {
      return (OResult) val;
    }

    OResult result = new OResult();
    if (val instanceof OIdentifiable) {
      result.setElement((OIdentifiable) val);
    } else {
      result.setProperty("value", val);
    }
    return result;
  }

  @Override public void close() {

  }

}
