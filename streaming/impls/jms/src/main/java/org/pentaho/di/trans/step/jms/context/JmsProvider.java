/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2018 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.trans.step.jms.context;

import org.pentaho.di.core.variables.VariableSpace;
import org.pentaho.di.trans.step.jms.JmsDelegate;

import javax.jms.Destination;
import javax.jms.JMSContext;

import static org.pentaho.di.i18n.BaseMessages.getString;
import static org.pentaho.di.trans.step.jms.JmsConstants.PKG;


public interface JmsProvider {

  boolean supports( ConnectionType type );

  JMSContext getContext( JmsDelegate meta, VariableSpace variableSpace );

  Destination getDestination( JmsDelegate meta, VariableSpace variableSpace );


  enum ConnectionType {
    WEBSPHERE {
      public String toString() {
        return getString( PKG, "JmsProvider.IBMMQ" );
      }

      public String getUrlHint() {
        return getString( PKG, "JmsProvider.WSUrlHint" );

      }

      public String getDestinationHint() {
        return getString( PKG, "JmsProvider.WSDestinationHint" );
      }
    },
    ACTIVEMQ {
      public String toString() {
        return getString( PKG, "JmsProvider.ActiveMQ" );
      }

      public String getUrlHint() {
        return getString( PKG, "JmsProvider.ActiveMQUrlHint" );

      }

      public String getDestinationHint() {
        return getString( PKG, "JmsProvider.ActiveMQDestinationHint" );
      }
    },
    JNDI {
      public String toString() {
        return getString( PKG, "JmsProvider.Generic" );
      }

      public String getUrlHint() {
        return getString( PKG, "JmsProvider.JndiUrlHint" );

      }

      public String getDestinationHint() {
        return getString( PKG, "JmsProvider.JndiDestinationHint" );
      }
    };

    public abstract String getUrlHint();

    public abstract String getDestinationHint();
  }

  enum DestinationType {
    QUEUE,
    TOPIC
  }

}

